package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.entity.Customer;

import java.util.List;

public interface CustomerService {
  List<Customer> findAll();

  Customer save(Customer customer);

}
