package it.euris.academy.webservicerest.utility;

import it.euris.academy.webservicerest.data.entity.Customer;

public class EntityUtils {

  public static Customer getCustomer(Integer id) {
    return Customer
        .builder()
        .id(id)
        .build();
  }

}
