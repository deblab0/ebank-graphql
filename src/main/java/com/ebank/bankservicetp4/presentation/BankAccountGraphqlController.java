package com.ebank.bankservicetp4.presentation;

import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountRequest;
import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountResponse;
import com.ebank.bankservicetp4.dtos.bankaccount.BankAccountDto;
import com.ebank.bankservicetp4.service.IBankAccountService;
import lombok.AllArgsConstructor;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
@Controller
@AllArgsConstructor
public class BankAccountGraphqlController {
    private final IBankAccountService bankAccountService;
    @QueryMapping
    List<BankAccountDto> bankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }
    @QueryMapping
    BankAccountDto bankAccountByRib(@Argument String rib) {
        return bankAccountService.getBankAccountByRib(rib);
    }

    @MutationMapping
    public AddBankAccountResponse addBankAccount(@Argument("dto") AddBankAccountRequest dto) {
        return bankAccountService.saveBankAccount(dto);
    }
}
