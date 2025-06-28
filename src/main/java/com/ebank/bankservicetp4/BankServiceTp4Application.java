package com.ebank.bankservicetp4;

import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountRequest;
import com.ebank.bankservicetp4.dtos.customer.AddCustomerRequest;
import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferRequest;
import com.ebank.bankservicetp4.service.IBankAccountService;
import com.ebank.bankservicetp4.service.ICustomerService;
import com.ebank.bankservicetp4.service.ITransactionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankServiceTp4Application {
    @Bean
    CommandLineRunner initDataBase(ICustomerService customerService,
                                   IBankAccountService bankAccountService,
                                   ITransactionService transactionService) {
        return args -> {
            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user1").
                    identityRef("A100").
                    firstname("FIRST_NAME1").
                    lastname("LAST_NAME1").
                    build());
            bankAccountService.saveBankAccount(AddBankAccountRequest.builder().
                    rib("RIB_1").
                    amount(1000000d).
                    customerIdentityRef("A100").
                    build());
            bankAccountService.saveBankAccount(AddBankAccountRequest.builder().
                    rib("RIB_11").
                    amount(2000000d).
                    customerIdentityRef("A100").
                    build());
            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user2").
                    identityRef("A200").
                    firstname("FIRST_NAME2").
                    lastname("LAST_NAME2").
                    build());
            bankAccountService.saveBankAccount(AddBankAccountRequest.builder().
                    rib("RIB_2").
                    amount(2000000d).
                    customerIdentityRef("A200").
                    build());
            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user3").
                    identityRef("A900").
                    firstname("FIRST_NAME9").
                    lastname("LAST_NAME9").
                    build());
            bankAccountService.saveBankAccount(AddBankAccountRequest.builder().
                    rib("RIB_9").
                    amount(-25000d).
                    customerIdentityRef("A900").
                    build());

            customerService.createCustomer(AddCustomerRequest.builder().
                    username("user4").
                    identityRef("A800").firstname("FIRST_NAME8").
                    lastname("LAST_NAME8").
                    build());
            bankAccountService.saveBankAccount(AddBankAccountRequest.builder().
                    rib("RIB_8").
                    amount(0.0).
                    customerIdentityRef("A800").
                    build());
            transactionService.wiredTransfer(AddWirerTransferRequest.builder().
                    ribFrom("RIB_1").
                    ribTo("RIB_2").
                    amount(10000.0).
                    username("user1").
                    build());
            transactionService.wiredTransfer(AddWirerTransferRequest.builder().
                    ribFrom("RIB_1").
                    ribTo("RIB_9").
                    amount(20000.0).
                    username("user1").
                    build());
            transactionService.wiredTransfer(AddWirerTransferRequest.builder().
                    ribFrom("RIB_1").
                    ribTo("RIB_8").
                    amount(500.0).
                    username("user1").
                    build());

            transactionService.wiredTransfer(AddWirerTransferRequest.builder().
                    ribFrom("RIB_2").
                    ribTo("RIB_11").
                    amount(300.0).
                    username("user2").
                    build());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BankServiceTp4Application.class, args);
    }
}
