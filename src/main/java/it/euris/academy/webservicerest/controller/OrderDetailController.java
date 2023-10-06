package it.euris.academy.webservicerest.controller;

import it.euris.academy.webservicerest.data.dto.OrderDetailDTO;
import it.euris.academy.webservicerest.data.entity.OrderDetail;
import it.euris.academy.webservicerest.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orderdetails")
public class OrderDetailController {

  OrderDetailService orderDetailService;

  @GetMapping("/v1")
  public List<OrderDetailDTO> findAll() {
    return orderDetailService.findAll().stream().map(OrderDetail::toDto).toList();
  }


}
