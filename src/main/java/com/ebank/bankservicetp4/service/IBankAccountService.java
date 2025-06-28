package com.ebank.bankservicetp4.service;

import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountRequest;
import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountResponse;
import com.ebank.bankservicetp4.dtos.bankaccount.BankAccountDto;

import java.util.List;

public interface IBankAccountService {
    AddBankAccountResponse saveBankAccount(AddBankAccountRequest dto);
    List<BankAccountDto> getAllBankAccounts();
    BankAccountDto getBankAccountByRib(String rib);
}
