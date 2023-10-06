package it.euris.academy.webservicerest.repository;

import it.euris.academy.webservicerest.data.entity.OrderDetail;
import it.euris.academy.webservicerest.data.entity.key.OrderDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailKey> {
}
