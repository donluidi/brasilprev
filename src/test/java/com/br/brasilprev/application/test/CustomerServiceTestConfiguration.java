package com.br.brasilprev.application.test;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.br.brasilprev.application.service.CustomerService;

@Profile("test")
@Configuration
public class CustomerServiceTestConfiguration {
    @Bean
    @Primary
    public CustomerService customerService() {
        return Mockito.mock(CustomerService.class);
    }
}
