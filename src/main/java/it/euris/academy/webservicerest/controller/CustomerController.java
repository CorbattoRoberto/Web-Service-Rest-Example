package it.euris.academy.webservicerest.controller;

import it.euris.academy.webservicerest.entity.Customer;
import it.euris.academy.webservicerest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

  CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.findAll();
  }

  @PostMapping
  public Customer saveCustomer(@RequestBody Customer customer) {
    return customerService.save(customer);
  }

  @PutMapping
  public Customer updateCustomer(@RequestBody Customer customer){
    return customerService.save(customer);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable("id") Integer idCustomer) {
    customerService.deleteById(idCustomer);
  }

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable("id") Integer idCustomer) {
    return customerService.findById(idCustomer);
  }

}
