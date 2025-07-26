package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String initiateTxn(Long sender, Long receiver, Long amount, String reason) {

        Transaction transaction = Transaction.builder()
                .externalTxnId(UUID.randomUUID().toString())
                .sender(sender)
                .receiver(receiver)
                .amount(amount)
                .reason(reason)
                .status(TransactionStatus.PENDING)
                .build();
        this.transactionRepository.save(transaction);

        JSONObject jsonObject = this.objectMapper.convertValue(transaction, JSONObject.class);

        this.kafkaTemplate.send("transaction-created", jsonObject.toString());

        return transaction.getExternalTxnId();
    }

    @KafkaListener(topics = "transaction-updated",groupId = "txnUpdate")
    public void completeTxn(String message){

        JSONObject jsonObject = (JSONObject) JSONValue.parse(message);

        String externalTxnId = jsonObject.get("externalTxnId").toString();
        String txnStatus = jsonObject.get("status").toString();

        Transaction txn = this.transactionRepository.findByExternalTxnId(externalTxnId);

        if(!txn.getStatus().equals(TransactionStatus.PENDING)){
            this.logger.info("Transaction already terminated");
            return;
        }

        TransactionStatus transactionStatus = txnStatus.equals("SUCCESS")
                ? TransactionStatus.SUCCESS
                : TransactionStatus.FAILED;

        txn.setStatus(transactionStatus);
        this.transactionRepository.save(txn);

//        this.kafkaTemplate.send("transaction-updated", jsonObject.toString());
// TODO create a notification service and then read from queue and try to give a notification on user screen
// TODO create a sync communication in same project
    }
}
