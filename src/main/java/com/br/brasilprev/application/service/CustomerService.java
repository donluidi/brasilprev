package com.br.brasilprev.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.br.brasilprev.application.customer.Customer;
import com.br.brasilprev.application.resource.CustomerResource;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerResource customerResource;

	@Cacheable(value = "customerIdCache", key = "#id", condition = "#id>0")
    public String getCustomerNameById(Long id) {
        return customerResource.getCustomerById(id).getNome();
    }
	
	@Cacheable(value="customerNameCache", key="#name")
	public Customer getCustomerByName(String name) {
		List<Customer> customerList = customerResource.getAllCustomers();
		for (Customer customer : customerList) {
			if (customer.getNome().equals(name)) {
				return customer;
			}
		}
		return null;
	}
}
