package it.euris.academy.webservicerest.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.academy.webservicerest.dto.CustomerDTO;
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
  @Operation(description = """
      This method is used to retrieve all the customers from the database<br>
      """)
  public List<Customer> getAllCustomers() {
    return customerService.findAll();
  }

  @PostMapping
  public Customer saveCustomer(@RequestBody CustomerDTO customerDTO) {
    Customer customer = (Customer) customerDTO.toModel();
    customer.setActive(true);
    return customerService.save(customer);
  }

  @PutMapping
  public Customer updateCustomer(@RequestBody CustomerDTO customerDTO){
    Customer customer = (Customer) customerDTO.toModel();
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
