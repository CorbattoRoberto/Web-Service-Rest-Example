package it.euris.academy.webservicerest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.academy.webservicerest.data.entity.Customer;
import it.euris.academy.webservicerest.service.CustomerService;
import it.euris.academy.webservicerest.utility.TestSupport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CustomerService customerService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldGetOneCustomer() throws Exception {

    Customer customer = TestSupport.getCustomer(1);
    List<Customer> customers = List.of(customer);

    when(customerService.findAll()).thenReturn(customers);

    mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(1))
        .andExpect(jsonPath("$[0].firstName").value(customer.getFirstName()))
        .andExpect(jsonPath("$[0].lastName").value(customer.getLastName()));
  }

  @Test
  void shouldInsertACustomer() throws Exception {

    Customer customer = TestSupport.getCustomer(1);

    when(customerService.insert(any())).thenReturn(customer);

    mockMvc.perform(post("/customers/v1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customer.toDto())))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.firstName").value(customer.getFirstName()))
        .andExpect(jsonPath("$.lastName").value(customer.getLastName()));
  }

}
