package com.br.brasilprev.application.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.br.brasilprev.application.BrasilPrevApplication;
import com.br.brasilprev.application.service.CustomerService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BrasilPrevApplication.class)
public class CustomerServiceUnitTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void whenCustomerIdIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(customerService.getCustomerNameById(1l)).thenReturn("Mock username");
        String testName = customerService.getCustomerNameById(1l);
        Assert.assertEquals("Mock username", testName);
    }
    
    @Test
    public void whenCustomerNameIsProvided_thenRetrievedNameIsCorrect() {
        Mockito.when(customerService.getCustomerByName("Paulo").getNome()).thenReturn("Mock username");
        String testName = customerService.getCustomerByName("Paulo").getNome();
        Assert.assertEquals("Mock username", testName);
    }
}