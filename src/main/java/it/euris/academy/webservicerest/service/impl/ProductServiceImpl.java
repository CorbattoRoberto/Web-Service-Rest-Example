package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.repository.ProductRepository;
import it.euris.academy.webservicerest.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  ProductRepository productRepository;

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }
}
