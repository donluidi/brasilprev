package com.br.brasilprev.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.brasilprev.application.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
