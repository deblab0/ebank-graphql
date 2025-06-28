package com.ebank.bankservicetp4.dtos.transaction;


import com.ebank.bankservicetp4.dtos.bankaccount.BankAccountDto;
import com.ebank.bankservicetp4.dtos.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionDto {
    private Long id;
    private String createdAt;
    private String transactionType;
    private Double amount;
    private BankAccountDto bankAccount;
    private UserDto user;
}
