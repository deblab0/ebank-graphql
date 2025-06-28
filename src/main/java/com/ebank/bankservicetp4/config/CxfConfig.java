package com.ebank.bankservicetp4.config;

import com.ebank.bankservicetp4.presentation.soap.BankSoapController;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {
    private Bus bus;
    private BankSoapController bankSoapController;

    @Bean
    public EndpointImpl bankWSEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, bankSoapController);
        endpoint.publish("/BankService");
        return endpoint;
    }
}
