package com.ebank.bankservicetp4.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddWirerTransferResponse {
    private String rib;
    private String dateTo;
    private String dateFrom;
    private String message;
    private TransactionDto transactionFrom;
    private TransactionDto transactionTo;
}
