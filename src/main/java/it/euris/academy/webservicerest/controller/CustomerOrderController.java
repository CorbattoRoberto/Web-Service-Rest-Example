package it.euris.academy.webservicerest.controller;

import it.euris.academy.webservicerest.data.dto.CustomerOrderDTO;
import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.service.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class CustomerOrderController {

  CustomerOrderService customerOrderService;

  @GetMapping("/v1")
  public List<CustomerOrderDTO> getAllCustomers() {
    return customerOrderService.findAll().stream().map(CustomerOrder::toDto).toList();
  }

  @PostMapping("/v1")
  public CustomerOrderDTO saveCustomer(@RequestBody CustomerOrderDTO customerOrderDTO) {
    try{
      CustomerOrder customerOrder = customerOrderDTO.toModel();
      return customerOrderService.insert(customerOrder).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public CustomerOrderDTO updateCustomer(@RequestBody CustomerOrderDTO customerOrderDTO) {
    CustomerOrder customerOrder = customerOrderDTO.toModel();
    return customerOrderService.update(customerOrder).toDto();
  }

  @GetMapping("/v1/{id}")
  public CustomerOrderDTO getCustomerById(@PathVariable("id") Integer idCustomer) {
    return customerOrderService.findById(idCustomer).toDto();
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Integer id)
  {
    return customerOrderService.deleteById(id);
  }








  @PostMapping("/v1/{orderId}/product/{productId}")
  public CustomerOrder addProductToOrder(
      @PathVariable("orderId") Integer orderId,
      @PathVariable("productId") Integer productId) {

    return customerOrderService.addProductToOrder(orderId, productId);

  }

}
