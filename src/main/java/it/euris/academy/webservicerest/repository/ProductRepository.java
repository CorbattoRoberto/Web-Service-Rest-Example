package it.euris.academy.webservicerest.repository;

import it.euris.academy.webservicerest.data.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  @Modifying
  @Transactional
  @Query(value="UPDATE product SET deleted = 1 WHERE id = :id", nativeQuery = true)
  void logicalDelete(@Param("id") Integer id);

}
