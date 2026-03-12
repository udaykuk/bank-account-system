package com.bank.bank_account_system.Controller;

import com.bank.bank_account_system.Entity.Account;
import com.bank.bank_account_system.Entity.Transaction;
import com.bank.bank_account_system.Repository.AccountRepo;
import com.bank.bank_account_system.Service.AccountService;
import com.bank.bank_account_system.dto.TransferRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account acc){
        Account saved=accountService.createAccount(acc.getName(),acc.getAccountType());
        return saved;
    }

    @GetMapping("/{accNo}")
    public Account getDetails(@PathVariable long accNo){
        return accountService.getAccount(accNo) ;
    }
    @PutMapping("/{accNo}")
    public Account updateDetails(@PathVariable long accNo,@RequestBody Account newAcc){
        return accountService.updateAccount(accNo,newAcc) ;
    }

    @DeleteMapping("/{accNo}")
    public void deleteDetails(@PathVariable long accNo){
         accountService.deleteAccount(accNo) ;
    }


    @PostMapping("/{accNo}/deposit")
    public void deposite(@PathVariable long accNo,@RequestBody BigDecimal balance){
        accountService.deposite(accNo,balance);
    }
    @PostMapping("/{accNo}/withdraw")
    public void withdraw(@PathVariable long accNo,@RequestBody BigDecimal balance) {
        accountService.withDraw(accNo, balance);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest req) {
        accountService.transfer(req.getFromAccNo(), req.getToAccNo(),req.getAmount() );
    }
    @GetMapping("/{accNo}/transactions")
    public List<Transaction> transactionHistory(@PathVariable long accNo){
        return accountService.transactionhistory(accNo);
    }

}
