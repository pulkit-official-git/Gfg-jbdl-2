package com.example.batch2onlinelibrary.services;

import com.example.batch2onlinelibrary.models.*;
import com.example.batch2onlinelibrary.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Value("${library.student.bookLimit}")
    private int bookLimit;

    @Value("${library.days.alowed}")
    private int daysAllowed;

    @Value("${library.finePerday}")
    private int finePerday;

    public String initiateTxn(Long studentId, Long bookId, TransactionType transactionType) throws Exception {
        switch (transactionType){
            case ISSUANCE:
                return initiateIssuanceTxn(studentId, bookId);
            case RETURN:
                return initiateReturnTxn(studentId, bookId);
                default:
                    throw new Exception("Invalid transaction type");

        }
    }

/*
* Steps
*
* 1. Validate book and student
* 2. Validate if book is available for issue
* 3. Validate student limit
* 4. Create a txn with status as pending
* 5. make book unavailable and assign it to student
* 6. Make the status as success
* 7. make it failed and handle accordingly
* */

    private String initiateIssuanceTxn(Long studentId, Long bookId) throws Exception {


//        ######### DATA RETRIEVAL #########

        Book book = this.bookService.getBookById(bookId);
        Student student = this.studentService.getStudentDetails(studentId).getStudent();

//        ########. Validations ##########

        if(student == null || student.getStatus() == StudentStatus.INACTIVE){
            throw new Exception("student is not present or not active");
        }

        if(book == null || book.getStudent() != null){
            throw new Exception("book is not available");
        }

        List<Book> issuedBooks = student.getIssuedBooks();
        if(issuedBooks != null && issuedBooks.size() > bookLimit){
            throw new Exception("student issued book limit exceeded");
        }

//        ISSUANCE logic #############

        Transaction transaction = Transaction.builder()
                .book(book)
                .student(student)
                .transactionType(TransactionType.ISSUANCE)
                .transactionStatus(TransactionStatus.PENDING)
                .externalId(UUID.randomUUID().toString())
                .build();

        transaction = transactionRepository.save(transaction);

        try {
            book.setStudent(student);
            book = this.bookService.addOrUpdate(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transaction = transactionRepository.save(transaction);
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction = transactionRepository.save(transaction);

            if(book.getStudent() != null){
                book.setStudent(null);
                book = this.bookService.addOrUpdate(book);
            }
        }

        return transaction.getExternalId();
    }

    public String initiateReturnTxn(Long studentId, Long bookId) throws Exception {


        //        ######### DATA RETRIEVAL #########

        Book book = this.bookService.getBookById(bookId);
        Student student = this.studentService.getStudentDetails(studentId).getStudent();

//        ########. Validations ##########

        if(student == null || student.getStatus() == StudentStatus.INACTIVE){
            throw new Exception("student is not present or not active");
        }

        if(book == null || book.getStudent() == null || book.getStudent().getId()!=studentId){
            throw new Exception("book is not aligned with student or not present");
        }

//        ##########. Return ############

        Transaction transaction = Transaction.builder()
                .book(book)
                .student(student)
                .transactionType(TransactionType.RETURN)
                .transactionStatus(TransactionStatus.PENDING)
                .externalId(UUID.randomUUID().toString())
                .build();

        transaction = transactionRepository.save(transaction);

        try {
            Integer fine = this.getFine(book, student);
            book.setStudent(null);
            book = this.bookService.addOrUpdate(book);

            transaction.setFine(fine);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transaction = transactionRepository.save(transaction);
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction = transactionRepository.save(transaction);
            if(book.getStudent() == null){
                book.setStudent(student);
                this.bookService.addOrUpdate(book);
            }
        }
        return transaction.getExternalId();
    }

    public Integer getFine(Book book, Student student){

        Transaction issuedTxn = this.transactionRepository.findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                book,student,TransactionType.ISSUANCE,TransactionStatus.SUCCESS
        );

        Long issuedTimeInMillis = issuedTxn.getUpdatedOn().getTime();
        Long timePassedInMillis = System.currentTimeMillis() - issuedTimeInMillis;

        Long daysPassed = TimeUnit.DAYS.convert(timePassedInMillis, TimeUnit.MILLISECONDS);

        if(daysPassed >= daysAllowed){
            return (daysPassed.intValue() - daysAllowed)*finePerday;
        }

        return 0;
    }

    public int add(int a, int  b){
        return a+b+1;
    }
}
