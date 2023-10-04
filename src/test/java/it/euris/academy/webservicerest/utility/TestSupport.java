package it.euris.academy.webservicerest.utility;

import it.euris.academy.webservicerest.data.entity.Customer;
import it.euris.academy.webservicerest.data.entity.CustomerOrder;

import java.time.LocalDateTime;

public class TestSupport {

  public static Customer getCustomer(Integer id) {
    return Customer
        .builder()
        .id(id)
        .firstName("Test firstName")
        .lastName("Test lastName")
        .address("Test address")
        .city("Test city")
        .email("test@testmail.com")
        .notes("Test Notes")
        .build();
  }

  public static CustomerOrder getCustomerOrder(Integer id) {
    Customer customer = getCustomer(1);
    return CustomerOrder
        .builder()
        .id(id)
        .customer(customer)
        .orderDate(LocalDateTime.now())
        .notes("Test notes")
        .build();
  }

}
