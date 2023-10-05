package it.euris.academy.webservicerest.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
@SecurityRequirement(name = "authentication")
public class ProductController {

  ProductService productService;

  @GetMapping("/v1")
  public List<Product> getAllProducts() {
    return productService.findAll();
  }

}
