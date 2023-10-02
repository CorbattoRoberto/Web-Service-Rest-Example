package it.euris.academy.webservicerest.repository;

import it.euris.academy.webservicerest.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
