package com.bank.bank_account_system.Repository;

import com.bank.bank_account_system.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {

}
