package com.ebank.bankservicetp4.dao;

import com.ebank.bankservicetp4.model.BankAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BankAccountTransactionRepository extends JpaRepository<BankAccountTransaction, Long> {
    List<BankAccountTransaction> findByBankAccountRibAndCreatedAtBetween(String rib, Date from, Date to);
}
