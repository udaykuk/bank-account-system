package com.bank.bank_account_system.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionID;
    private BigDecimal amount;
    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn(name="accountNo")
    private Account receiverAccountNumber;
    private Date transactiondate;

        public enum TransactionType {
        CREDIT,DEBIT
        }
}
