package it.euris.academy.webservicerest.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.euris.academy.webservicerest.data.dto.CustomerDTO;
import it.euris.academy.webservicerest.data.entity.Customer;
import it.euris.academy.webservicerest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

  CustomerService customerService;

  @GetMapping("/v1")
  @Operation(description = """
      This method is used to retrieve all the customers from the database<br>
      """)
  public List<CustomerDTO> getAllCustomers() {
    return customerService.findAll().stream().map(Customer::toDto).toList();
  }

  @PostMapping("/v1")
  public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO) {
    Customer customer = customerDTO.toModel();
    return customerService.insert(customer).toDto();
  }

  @PutMapping("/v1")
  public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
    Customer customer = customerDTO.toModel();
    return customerService.update(customer).toDto();
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Integer idCustomer) {
    return customerService.deleteById(idCustomer);
  }

  @GetMapping("/v1/{id}")
  public CustomerDTO getCustomerById(@PathVariable("id") Integer idCustomer) {
    return customerService.findById(idCustomer).toDto();
  }

}
