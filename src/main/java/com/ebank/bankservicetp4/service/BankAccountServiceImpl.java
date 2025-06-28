package com.ebank.bankservicetp4.service;

import com.ebank.bankservicetp4.dao.BankAccountRepository;
import com.ebank.bankservicetp4.dao.CustomerRepository;
import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountRequest;
import com.ebank.bankservicetp4.dtos.bankaccount.AddBankAccountResponse;
import com.ebank.bankservicetp4.dtos.bankaccount.BankAccountDto;
import com.ebank.bankservicetp4.enums.AccountStatus;
import com.ebank.bankservicetp4.model.BankAccount;
import com.ebank.bankservicetp4.model.Customer;
import com.ebank.bankservicetp4.service.exception.BusinessException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements IBankAccountService{
    private final BankAccountRepository bankAccountRepository;
    private final CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    @Override
    public AddBankAccountResponse saveBankAccount(AddBankAccountRequest dto){
        BankAccount bankAccount= modelMapper.map(dto, BankAccount.class);
        Customer customerP = customerRepository.findByIdentityRef(bankAccount.getCustomer().getIdentityRef()).orElseThrow(()->new BusinessException(String.format("No customer with identity %s exist", dto.getCustomerIdentityRef())));
        bankAccount.setAccountStatus(AccountStatus.OPENED);
        bankAccount.setCustomer(customerP);
        bankAccount.setCreatedAt(new Date());
        AddBankAccountResponse response = modelMapper.map(bankAccountRepository.save(bankAccount), AddBankAccountResponse.class);
        response.setMessage(String.format("RIB number [%s] for the customer [%s] has been successfully created", dto.getRib(), dto.getCustomerIdentityRef()));
        return response;
    }

    @Override
    public List<BankAccountDto> getAllBankAccounts(){
        return bankAccountRepository.findAll()
                .stream()
                .map(bankAccount -> modelMapper.map(bankAccount, BankAccountDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BankAccountDto getBankAccountByRib(String rib){
        return modelMapper.map(bankAccountRepository.findByRib(rib).orElseThrow(()->new BusinessException(String.format("No Bank Account with rib [%s] exist", rib))), BankAccountDto.class);
    }


}
