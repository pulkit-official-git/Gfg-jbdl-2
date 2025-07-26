package com.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WalletService {

    Logger logger= LoggerFactory.getLogger(WalletService.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private WalletRepository walletRepository;

    @Value("${wallet.start.balance}")
    private Long startBalance;

    @KafkaListener(topics = "user-created",groupId = "walletGroup")
    public void createWallet(String message){

        JSONObject jsonObject = (JSONObject) JSONValue.parse(message);
        Long userId = (Long) jsonObject.get("id");

        Wallet wallet = this.walletRepository.findByUserId(userId);

        if(wallet!=null){
            this.logger.info("wallet for this user already exist");
        }
        wallet = Wallet.builder()
                .id(UUID.randomUUID().toString())
                .userId(userId)
                .balance(startBalance)
                .status(WalletStatus.ACTIVE)
                .build();

        this.walletRepository.save(wallet);

//        System.out.println(jsonObject);
        logger.info(jsonObject.toJSONString());

    }

    @KafkaListener(topics = "transaction-created",groupId = "transactionGroup")
    public void updateWallet(String message){

        JSONObject jsonObject = (JSONObject) JSONValue.parse(message);
        Long sender = (Long) jsonObject.get("sender");
        Long receiver = (Long) jsonObject.get("receiver");
        Long amount = (Long) jsonObject.get("amount");

        String externalTxnId = (String) jsonObject.get("externalTxnId");


        Wallet receiverWallet = this.walletRepository.findByUserId(receiver);
        Wallet senderWallet = this.walletRepository.findByUserId(sender);

        if(senderWallet==null || receiverWallet==null || amount<0 || senderWallet.getBalance()<amount){
            this.logger.info("wallet cannot be updated as either wallet is not present or amount is not valid");

            JSONObject event = new JSONObject();
            event.put("status","FAILED");
            event.put("sender",sender);
            event.put("receiver",receiver);
            event.put("externalTxnId",externalTxnId);

            this.kafkaTemplate.send("transaction-updated",event.toString());
            return;

        }

        receiverWallet.setBalance(receiverWallet.getBalance()+amount);
        senderWallet.setBalance(senderWallet.getBalance()-amount);
        this.walletRepository.saveAll(List.of(receiverWallet,senderWallet));

        JSONObject event = new JSONObject();
        event.put("status","SUCCESS");
        event.put("sender",sender);
        event.put("receiver",receiver);
        event.put("externalTxnId",externalTxnId);

        this.kafkaTemplate.send("transaction-updated",event.toString());

    }
}
