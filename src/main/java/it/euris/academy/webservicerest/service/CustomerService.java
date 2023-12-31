package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.data.entity.Customer;

import java.util.List;

public interface CustomerService {
  List<Customer> findAll();

  Customer insert(Customer customer);

  Customer update(Customer customer);

  Boolean deleteById(Integer idCustomer);

  Customer findById(Integer idCustomer);
}
