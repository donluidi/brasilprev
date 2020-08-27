package com.br.brasilprev.application.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.brasilprev.application.customer.Customer;
import com.br.brasilprev.application.exception.CustomerNotFoundException;
import com.br.brasilprev.application.repository.CustomerRepository;

@RestController
public class CustomerResource {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent())
			throw new CustomerNotFoundException("id-" + id);

		return customer.get();
	}

	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable long id) {
		customerRepository.deleteById(id);
	}

	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerRepository.save(customer);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newCustomer.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {

		Optional<Customer> updatedCustomer = customerRepository.findById(id);

		if (!updatedCustomer.isPresent())
			return ResponseEntity.notFound().build();

		customer.setId(id);

		customerRepository.save(customer);

		return ResponseEntity.noContent().build();
	}
}
