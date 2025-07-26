package com.example;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalTxnId;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private Long amount;

    private Long sender;

    private Long receiver;

    private String reason;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    private String txnFailureReason;
}
