package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.data.entity.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {


  List<CustomerOrder> findAll();

  CustomerOrder insert(CustomerOrder customer);

  CustomerOrder update(CustomerOrder customer);

  Boolean deleteById(Integer id);

  CustomerOrder findById(Integer idCustomer);

  public CustomerOrder addProductToOrder(Integer orderId, Integer productId);

}
