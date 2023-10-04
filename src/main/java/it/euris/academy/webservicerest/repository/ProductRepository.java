package it.euris.academy.webservicerest.repository;

import it.euris.academy.webservicerest.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
