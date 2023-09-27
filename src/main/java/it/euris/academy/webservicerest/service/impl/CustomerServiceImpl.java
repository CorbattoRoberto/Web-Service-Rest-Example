package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.entity.Customer;
import it.euris.academy.webservicerest.repository.CustomerRepository;
import it.euris.academy.webservicerest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository customerRepository;

  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

}
