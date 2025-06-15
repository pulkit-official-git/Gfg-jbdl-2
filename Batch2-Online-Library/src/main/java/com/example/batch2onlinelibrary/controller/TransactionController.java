package com.example.batch2onlinelibrary.controller;

import com.example.batch2onlinelibrary.models.TransactionType;
import com.example.batch2onlinelibrary.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/initiate")
    public String initiateTxn(@RequestParam("studentId") Long studentId,
                              @RequestParam("bookId") Long bookId,
                              @RequestParam("transactionType")TransactionType transactionType) throws Exception {
        return this.transactionService.initiateTxn(studentId,bookId,transactionType);
    }
}
