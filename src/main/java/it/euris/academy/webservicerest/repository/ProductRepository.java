package it.euris.academy.webservicerest.repository;

import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.repository.projection.ProductCountProjection;
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

  @Query(
      value =
          "SELECT COUNT(a.id) as countAll, "
              + " SUM(CASE WHEN a.deleted=0 THEN 1 ELSE 0 END) as countOk, "
              + " SUM(CASE WHEN a.deleted=1 THEN 1 ELSE 0 END) as countDeleted "
              + "   FROM product a",
      nativeQuery = true)
  ProductCountProjection getCount();

}
