package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/initiate")
    public String initiateTxn(@RequestParam("sender") Long sender,
                              @RequestParam("receiver") Long receiver,
                              @RequestParam("amount") Long amount,
                              @RequestParam("reason") String reason) {
        return this.transactionService.initiateTxn(sender,receiver,amount,reason);
    }
}
