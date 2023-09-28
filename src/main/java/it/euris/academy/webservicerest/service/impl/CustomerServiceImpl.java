package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.entity.Customer;
import it.euris.academy.webservicerest.repository.CustomerRepository;
import it.euris.academy.webservicerest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository customerRepository;

  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public void deleteById(Integer idCustomer) {
    customerRepository.deleteById(idCustomer);
  }

  @Override
  public Customer findById(Integer idCustomer) {
    return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
  }

}
