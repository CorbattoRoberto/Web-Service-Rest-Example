package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
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

  @Override
  public Product insert(Product product) {
    if(product.getId() != null) {
      throw new IdMustBeNullException();
    }
    return productRepository.save(product);
  }

  @Override
  public Product update(Product product) {
    if(product.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return productRepository.save(product);
  }

  @Override
  public Boolean deleteById(Integer idProduct) {
    productRepository.deleteById(idProduct);
    return productRepository.findById(idProduct).isEmpty();

//    productRepository.logicalDelete(idProduct);
//    return productRepository.findById(idProduct).get().getDeleted();

  }
}
