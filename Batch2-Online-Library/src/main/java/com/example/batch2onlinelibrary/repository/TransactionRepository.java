package com.example.batch2onlinelibrary.repository;

import com.example.batch2onlinelibrary.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findTopByBookAndStudentAndTransactionTypeAndTransactionStatusOrderByIdDesc(
            Book book, Student student, TransactionType transactionType, TransactionStatus transactionStatus
    );
}
