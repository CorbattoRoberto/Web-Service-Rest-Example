package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.data.entity.OrderDetail;
import it.euris.academy.webservicerest.data.entity.key.OrderDetailKey;
import it.euris.academy.webservicerest.repository.OrderDetailRepository;
import it.euris.academy.webservicerest.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

  OrderDetailRepository orderDetailRepository;

  @Override
  public List<OrderDetail> findAll() {
    return orderDetailRepository.findAll();
  }

  @Override
  public OrderDetail insert(OrderDetail orderDetail) {
    return null;
  }

  @Override
  public Boolean deleteById(OrderDetailKey orderDetailId) {
    return null;
  }

  @Override
  public OrderDetail findById(Integer orderId, Integer productId) {
    return null;
  }
}
