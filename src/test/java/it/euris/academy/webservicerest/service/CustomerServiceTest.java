package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.entity.Customer;
import it.euris.academy.webservicerest.repository.CustomerRepository;
import it.euris.academy.webservicerest.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerServiceTest {

  @MockBean
  CustomerRepository customerRepository;

  @Autowired
  CustomerService customerService;

  @Test
  void shouldReturnACustomer(){

    Customer customer = TestSupport.getCustomer(1);

    List<Customer> customers = List.of(customer);

    when(customerRepository.findAll()).thenReturn(customers);

    List<Customer> returnedCustomers = customerService.findAll();

    assertThat(returnedCustomers)
        .hasSize(1)
        .first()
        .usingRecursiveComparison()
        .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
        .isEqualTo(customer);
  }

  @Test
  void shouldInsertACustomer(){

    Customer customer = TestSupport.getCustomer(null);

    when(customerRepository.save(any())).thenReturn(customer);

    Customer returnedCustomer = customerService.insert(customer);
    assertThat(returnedCustomer.getFirstName())
        .isEqualTo(customer.getFirstName());
  }

  @Test
  void shouldDeleteACustomer() {
    //arrange
    Integer id = 12;

    doNothing().when(customerRepository).deleteById(anyInt());

    // Non necessario ma alternativo al when precedente
    when(customerRepository.findById(id)).thenReturn(Optional.empty());

    customerService.deleteById(id);
    //act+assert
//    assertTrue(customerService.deleteById(id));

    Mockito.verify(customerRepository, times(1)).deleteById(id);
  }


}
