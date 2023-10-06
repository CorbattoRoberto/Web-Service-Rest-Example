package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.data.entity.OrderDetail;
import it.euris.academy.webservicerest.data.entity.key.OrderDetailKey;

import java.util.List;

public interface OrderDetailService {

  List<OrderDetail> findAll();

  OrderDetail insert(OrderDetail orderDetail);

  Boolean deleteById(OrderDetailKey orderDetailId);

  OrderDetail findById(Integer orderId, Integer productId);

}
