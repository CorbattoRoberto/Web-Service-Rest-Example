package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.data.entity.Customer;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
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

  @Override
  public Customer insert(Customer customer) {
    if(customer.getId() != null && customer.getId() > 0) {
      throw new IdMustBeNullException();
    }
    return customerRepository.save(customer);
  }

  @Override
  public Customer update(Customer customer) {
    if(customer.getId() == null || customer.getId() == 0) {
      throw new IdMustNotBeNullException();
    }
    return customerRepository.save(customer);
  }

  @Override
  public Boolean deleteById(Integer idCustomer) {
    customerRepository.deleteById(idCustomer);
    return customerRepository.findById(idCustomer).isEmpty();
  }

  @Override
  public Customer findById(Integer idCustomer) {
    return customerRepository.findById(idCustomer).orElse(Customer.builder().build());
  }

}
