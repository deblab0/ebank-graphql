package com.ebank.bankservicetp4.presentation;

import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferRequest;
import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferResponse;
import com.ebank.bankservicetp4.dtos.transaction.GetTransactionListRequest;
import com.ebank.bankservicetp4.dtos.transaction.TransactionDto;
import com.ebank.bankservicetp4.service.ITransactionService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class TransactionGraphqlController {
    private ITransactionService transactionService;
    @MutationMapping
    public AddWirerTransferResponse addWirerTransfer(@Argument("dto") AddWirerTransferRequest dto) {
        return transactionService.wiredTransfer(dto);
    }
    @QueryMapping
    public List<TransactionDto> getTransactions(@Argument GetTransactionListRequest dto) {
        return transactionService.getTransactions(dto);
    }
}
