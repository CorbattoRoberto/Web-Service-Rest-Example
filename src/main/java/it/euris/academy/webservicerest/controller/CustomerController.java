package it.euris.academy.webservicerest.controller;

import it.euris.academy.webservicerest.entity.Customer;
import it.euris.academy.webservicerest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

  CustomerService customerService;

  @GetMapping("/")
  public List<Customer> getAllCustomers() {

    return customerService.findAll();

  }



}
