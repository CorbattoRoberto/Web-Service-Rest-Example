package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
import it.euris.academy.webservicerest.repository.CustomerOrderRepository;
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
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerOrderServiceTest {

  @Autowired
  CustomerOrderService customerOrderService;

  @MockBean
  CustomerOrderRepository customerOrderRepository;

  @Test
  void shouldReturnACustomerOrder(){

    CustomerOrder customerOrder = TestSupport.getCustomerOrder(1);

    List<CustomerOrder> customerOrders = List.of(customerOrder);

    when(customerOrderRepository.findAll()).thenReturn(customerOrders);

    List<CustomerOrder> returnedCustomerOrders = customerOrderService.findAll();

    assertThat(returnedCustomerOrders)
        .hasSize(1)
        .first()
        .usingRecursiveComparison()
        .withIntrospectionStrategy(new ComparingSnakeOrCamelCaseFields())
        .isEqualTo(customerOrder);
  }

  @Test
  void shouldInsertACustomerOrder(){

    CustomerOrder customerOrder = TestSupport.getCustomerOrder(null);
    when(customerOrderRepository.save(any())).thenReturn(customerOrder);

    CustomerOrder returnedCustomerOrder = customerOrderService.insert(customerOrder);
    assertThat(returnedCustomerOrder.getNotes())
        .isEqualTo(customerOrder.getNotes());
  }

  @Test
  void shouldNotInsertAnyCustomer(){

    CustomerOrder customerOrder = TestSupport.getCustomerOrder(1);
    when(customerOrderRepository.save(any())).thenReturn(customerOrder);

    assertThrows(IdMustBeNullException.class, () -> customerOrderService.insert(customerOrder));

    assertThatThrownBy(() -> customerOrderService.insert(customerOrder))
        .isInstanceOf(IdMustBeNullException.class);

  }

  @Test
  void shouldUpdateACustomer(){

    CustomerOrder customerOrder = TestSupport.getCustomerOrder(1);

    when(customerOrderRepository.save(any())).thenReturn(customerOrder);

    CustomerOrder returnedCustomerOrder = customerOrderService.update(customerOrder);
    assertThat(returnedCustomerOrder.getNotes())
        .isEqualTo(customerOrder.getNotes());
  }

  @Test
  void shouldNotUpdateAnyCustomer(){

    CustomerOrder customerOrder = TestSupport.getCustomerOrder(null);
    when(customerOrderRepository.save(any())).thenReturn(customerOrder);

    assertThatThrownBy(() -> customerOrderService.update(customerOrder))
        .isInstanceOf(IdMustNotBeNullException.class);
  }

  @Test
  void shouldDeleteACustomer() {
    //arrange
    Integer id = 12;
    doNothing().when(customerOrderRepository).deleteById(id);
    when(customerOrderRepository.findById(id)).thenReturn(Optional.empty());

    //act+assert
    assertTrue(customerOrderService.deleteById(id));
    Mockito.verify(customerOrderRepository, times(1)).deleteById(id);
  }

}
