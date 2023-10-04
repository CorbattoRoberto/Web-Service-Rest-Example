package it.euris.academy.webservicerest.service.impl;

import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.exception.IdMustBeNullException;
import it.euris.academy.webservicerest.exception.IdMustNotBeNullException;
import it.euris.academy.webservicerest.repository.CustomerOrderRepository;
import it.euris.academy.webservicerest.repository.ProductRepository;
import it.euris.academy.webservicerest.service.CustomerOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService {

  CustomerOrderRepository customerOrderRepository;
  ProductRepository productRepository;

  @Override
  public List<CustomerOrder> findAll() {
    return customerOrderRepository.findAll();
  }

  @Override
  public CustomerOrder insert(CustomerOrder customerOrder) {
    if(customerOrder.getId() != null) {
      throw new IdMustBeNullException();
    }
    return customerOrderRepository.save(customerOrder);
  }

  @Override
  public CustomerOrder update(CustomerOrder customerOrder) {
    if(customerOrder.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return customerOrderRepository.save(customerOrder);
  }

  @Override
  public Boolean deleteById(Integer idCustomerOrder) {
    customerOrderRepository.deleteById(idCustomerOrder);
    return customerOrderRepository.findById(idCustomerOrder).isEmpty();
  }

  @Override
  public CustomerOrder findById(Integer idCustomerOrder) {
    return customerOrderRepository.findById(idCustomerOrder).orElse(CustomerOrder.builder().build());
  }

  @Override
  public CustomerOrder addProductToOrder(Integer orderId, Integer productId) {

    Optional<CustomerOrder> customerOrderOptional = customerOrderRepository.findById(orderId);
    Optional<Product> productOptional = productRepository.findById(productId);

    if(customerOrderOptional.isPresent() && productOptional.isPresent()) {
      CustomerOrder customerOrder = customerOrderOptional.get();
      List<Product> products = List.of(productOptional.get());
//      customerOrder.setProducts(products);
      customerOrderRepository.save(customerOrder);
      return customerOrder;
    }
    else {
      throw new RuntimeException("Unable to insert the order detail");
    }
  }
}
