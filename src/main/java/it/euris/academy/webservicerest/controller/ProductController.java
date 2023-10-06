package it.euris.academy.webservicerest.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.euris.academy.webservicerest.data.dto.ProductDTO;
import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
import it.euris.academy.webservicerest.repository.projection.ProductCountProjection;
import it.euris.academy.webservicerest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

  @PostMapping("/v1")
  public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
    try{
      Product product = productDTO.toModel();
      return productService.insert(product).toDto();
    }
    catch(IdMustBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/v1")
  public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
    try{
      Product product = productDTO.toModel();
      return productService.update(product).toDto();
    }
    catch(IdMustNotBeNullException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @DeleteMapping("/v1/{id}")
  public Boolean deleteCustomer(@PathVariable("id") Integer id)
  {
    return productService.deleteById(id);
  }

  @GetMapping("/v1/count")
  public ProductCountProjection getCount() {
    return productService.getCount();
  }

}
