package it.euris.academy.webservicerest.controller;

import it.euris.academy.webservicerest.data.dto.OrderDetailDTO;
import it.euris.academy.webservicerest.data.entity.OrderDetail;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
import it.euris.academy.webservicerest.service.OrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

  @PostMapping("/v1")
  public OrderDetailDTO insert(@RequestBody OrderDetailDTO orderDetailDTO) {
    try {
      return orderDetailService.insert(orderDetailDTO.toModel()).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/v1/{order-id}-{product-id}")
  public OrderDetailDTO findById(@PathVariable("order-id") Integer orderId,
      @PathVariable("product-id") Integer productId) {

    return orderDetailService.findById(orderId,productId).toDto();
  }


}
