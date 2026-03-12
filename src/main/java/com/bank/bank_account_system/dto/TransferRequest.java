package com.bank.bank_account_system.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private long fromAccNo;
    private long toAccNo;
    private BigDecimal amount;


}
