package com.bank.bank_account_system.Service;

import com.bank.bank_account_system.Entity.Account;
import com.bank.bank_account_system.Repository.AccountRepo;
import com.bank.bank_account_system.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransactionRepo transactionRepo;

    public Account createAccount(String name, Account.AccountType accountType) {
        Account account = new Account();
        account.setName(name);
        account.setAccountType(accountType);
        accountRepo.save(account);
        return account;
    }

         public Account getAccount(long accNo){
             return accountRepo.findById(accNo).orElse(null);
        }

        public Account updateAccount(long accNo, Account acc){
            Account existing = getAccount(accNo);
            existing.setName(acc.getName());
            existing.setAccountType(acc.getAccountType());
            return accountRepo.save(existing);
        }
        public void deleteAccount(long accNo) {
//            accountRepo.delete(accountRepo.findById(accNo).orElse(null));
            accountRepo.deleteById(accNo);
        }
        public void deposite(long accNo, BigDecimal amount){
        Account change=getAccount(accNo);
        change.setBalance(change.getBalance().add(amount));
            accountRepo.save(change);
        }
        public void withDraw(long accNo, BigDecimal amount){
           Account change=getAccount(accNo);
           if(change.getBalance().compareTo(amount)>0){
                change.setBalance(change.getBalance().subtract(amount));
                accountRepo.save(change);
           }
           else throw new RuntimeException("Insufficient funds!");


    }
    public void transfer(long accNoFrom,long accNoTo,BigDecimal amount){
        withDraw(accNoFrom,amount);
        deposite(accNoTo,amount);
    }

}
