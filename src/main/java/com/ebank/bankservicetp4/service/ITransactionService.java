package com.ebank.bankservicetp4.service;

import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferRequest;
import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferResponse;
import com.ebank.bankservicetp4.dtos.transaction.GetTransactionListRequest;
import com.ebank.bankservicetp4.dtos.transaction.TransactionDto;

import java.util.List;

public interface ITransactionService {
    AddWirerTransferResponse wiredTransfer(AddWirerTransferRequest dto);
    List<TransactionDto> getTransactions(GetTransactionListRequest dto);
}
