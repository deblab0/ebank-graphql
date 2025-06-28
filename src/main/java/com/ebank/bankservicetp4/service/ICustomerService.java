package com.ebank.bankservicetp4.service;

import com.ebank.bankservicetp4.dtos.customer.*;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();
    AddCustomerResponse createCustomer(AddCustomerRequest addCustomerRequest);
    UpdateCustomerResponse updateCustomer(String identityRef, UpdateCustomerRequest updateCustomerRequest);
    CustomerDto getCustomByIdentity(String identity);
    String deleteCustomerByIdentityRef(String identityRef);
}
