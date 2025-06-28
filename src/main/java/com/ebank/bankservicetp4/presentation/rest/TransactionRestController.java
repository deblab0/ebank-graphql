package com.ebank.bankservicetp4.presentation.rest;

import com.ebank.bankservicetp4.common.CommonTools;
import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferRequest;
import com.ebank.bankservicetp4.dtos.transaction.AddWirerTransferResponse;
import com.ebank.bankservicetp4.dtos.transaction.GetTransactionListRequest;
import com.ebank.bankservicetp4.dtos.transaction.TransactionDto;
import com.ebank.bankservicetp4.service.ITransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rest/transaction")
@CrossOrigin("http://localhost:3000/")
public class TransactionRestController {
    private ITransactionService transactionService;
    private CommonTools commonTools;
    @PostMapping("/create")
    public ResponseEntity<AddWirerTransferResponse> addWirerTransfer(@Valid @RequestBody
                                                                     AddWirerTransferRequest dto) {
        return new ResponseEntity<>(transactionService.wiredTransfer(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public List<TransactionDto> getTransactions(GetTransactionListRequest dto) {
        return transactionService.getTransactions(dto);
    }
}
