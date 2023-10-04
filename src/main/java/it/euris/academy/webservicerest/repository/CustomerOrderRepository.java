package it.euris.academy.webservicerest.repository;

import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
}
