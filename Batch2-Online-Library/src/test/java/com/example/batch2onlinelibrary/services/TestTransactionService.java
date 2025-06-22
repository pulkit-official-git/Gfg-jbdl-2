package com.example.batch2onlinelibrary.services;

import com.example.batch2onlinelibrary.dtos.GetStudentDetails;
import com.example.batch2onlinelibrary.models.*;
import com.example.batch2onlinelibrary.repository.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class TestTransactionService {


    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private BookService bookService;

    @Mock
    private StudentService studentService;


    @Test
    public void testGetFineWithFine(){

        Book book = Book
                .builder()
                .id(1L)
                .name("Intro to Maths")
                .build();

        Student student = Student
                .builder()
                .id(1L)
                .name("Posty")
                .build();

        Transaction transaction = Transaction
                .builder()
                .id(1L)
                .book(book)
                .student(student)
                .transactionType(TransactionType.ISSUANCE)
                .transactionStatus(TransactionStatus.SUCCESS)
                .updatedOn(new Date(1747886412000L))
                .build();

        Mockito.when(transactionRepository.findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                        Mockito.eq(book),
                        Mockito.eq(student),
                        Mockito.eq(TransactionType.ISSUANCE),
                        Mockito.eq(TransactionStatus.SUCCESS)
                ))
                .thenReturn(transaction);

        ReflectionTestUtils.setField(transactionService, "finePerday", 1);
        ReflectionTestUtils.setField(transactionService, "daysAllowed", 15);

        int actual = transactionService.getFine(book,student);
        Assert.assertEquals(16,actual);

    }

    @Test
    public void testGetFineWithNoFine(){

        Book book = Book
                .builder()
                .id(1L)
                .name("Intro to Maths")
                .build();

        Student student = Student
                .builder()
                .id(1L)
                .name("Posty")
                .build();

        Transaction transaction = Transaction
                .builder()
                .id(1L)
                .book(book)
                .student(student)
                .transactionType(TransactionType.ISSUANCE)
                .transactionStatus(TransactionStatus.SUCCESS)
                .updatedOn(new Date(1750565597000L))
                .build();

        Mockito.when(transactionRepository.findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                        Mockito.eq(book),
                        Mockito.eq(student),
                        Mockito.eq(TransactionType.ISSUANCE),
                        Mockito.eq(TransactionStatus.SUCCESS)
                ))
                .thenReturn(transaction);

        ReflectionTestUtils.setField(transactionService, "finePerday", 1);
        ReflectionTestUtils.setField(transactionService, "daysAllowed", 15);

        int actual = transactionService.getFine(book,student);
        Assert.assertEquals(0,actual);

    }

    @Test
    public void TestInitiateReturnTxn() throws Exception {


        Student student = Student
                .builder()
                .id(1L)
                .name("Posty")
                .build();

        Book book = Book
                .builder()
                .id(1L)
                .name("Intro to Maths")
                .student(student)
                .build();

        String txnId = UUID.randomUUID().toString();

        Transaction transaction = Transaction
                .builder()
                .id(1L)
                .book(book)
                .student(student)
                .externalId(txnId)
                .transactionType(TransactionType.ISSUANCE)
                .transactionStatus(TransactionStatus.SUCCESS)
                .updatedOn(new Date(1750565597000L))
                .build();

        GetStudentDetails getStudentDetails = GetStudentDetails
                .builder()
                .student(student)
                .build();

        Mockito.when(bookService.getBookById(1L)).thenReturn(book);
        Mockito.when(studentService.getStudentDetails(1L)).thenReturn(getStudentDetails);

        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);

        Mockito.when(transactionRepository.findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                        Mockito.eq(book),
                        Mockito.eq(student),
                        Mockito.eq(TransactionType.ISSUANCE),
                        Mockito.eq(TransactionStatus.SUCCESS)
                ))
                .thenReturn(transaction);

        ReflectionTestUtils.setField(transactionService, "finePerday", 1);
        ReflectionTestUtils.setField(transactionService, "daysAllowed", 15);

        Mockito.when(bookService.addOrUpdate(Mockito.any(Book.class))).thenReturn(book);

        String actualTxnId = transactionService.initiateReturnTxn(1L,1L);

        Assert.assertEquals(txnId,actualTxnId);

    }

    @Test(expected = Exception.class)
    public void TestInitiateReturnTxnWithNoStudent() throws Exception {


        Book book = Book
                .builder()
                .id(1L)
                .name("Intro to Maths")
                .student(null)
                .build();

        String txnId = UUID.randomUUID().toString();


        GetStudentDetails getStudentDetails = GetStudentDetails
                .builder()
                .student(null)
                .build();

        Mockito.when(bookService.getBookById(1L)).thenReturn(book);
        Mockito.when(studentService.getStudentDetails(1L)).thenReturn(getStudentDetails);

        String actualTxnId = transactionService.initiateReturnTxn(1L,1L);

    }


}
