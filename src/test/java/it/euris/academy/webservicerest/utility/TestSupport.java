package it.euris.academy.webservicerest.utility;

import it.euris.academy.webservicerest.data.entity.Customer;

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

}
