package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.data.entity.Customer;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
import it.euris.academy.webservicerest.repository.CustomerRepository;
import it.euris.academy.webservicerest.service.impl.CustomerServiceImpl;
import it.euris.academy.webservicerest.utility.TestSupport;
import org.assertj.core.api.recursive.comparison.ComparingSnakeOrCamelCaseFields;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

  @Mock
  CustomerRepository customerRepository;

  @InjectMocks
  CustomerServiceImpl customerService;

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
  void shouldNotInsertAnyCustomer(){

    Customer customer = TestSupport.getCustomer(1);
    lenient().when(customerRepository.save(any())).thenReturn(customer);

    assertThrows(IdMustBeNullException.class, () -> customerService.insert(customer));

    assertThatThrownBy(() -> customerService.insert(customer))
        .isInstanceOf(IdMustBeNullException.class);

  }

  @Test
  void shouldUpdateACustomer(){

    Customer customer = TestSupport.getCustomer(1);

    when(customerRepository.save(any())).thenReturn(customer);

    Customer returnedCustomer = customerService.update(customer);
    assertThat(returnedCustomer.getFirstName())
        .isEqualTo(customer.getFirstName());
  }

  @Test
  void shouldNotUpdateAnyCustomer(){

    Customer customer = TestSupport.getCustomer(null);
    lenient().when(customerRepository.save(any())).thenReturn(customer);

    assertThatThrownBy(() -> customerService.update(customer))
        .isInstanceOf(IdMustNotBeNullException.class);
  }

  @Test
  void shouldDeleteACustomer() {
    //arrange
    Integer id = 12;

    doNothing().when(customerRepository).deleteById(anyInt());
    when(customerRepository.findById(id)).thenReturn(Optional.empty());
    assertTrue(customerService.deleteById(id));
    Mockito.verify(customerRepository, times(1)).deleteById(id);
  }

}
