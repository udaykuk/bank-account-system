package com.bank.bank_account_system.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNo;
    private String name;
    private BigDecimal balance;
    private AccountType accountType;

    public enum AccountType{
        SAVING,CURRENT;
    }
    private Date dateCreated;
}

