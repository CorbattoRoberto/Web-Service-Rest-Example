package it.euris.academy.webservicerest.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.webservicerest.data.dto.CustomerOrderDTO;
import it.euris.academy.webservicerest.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.localDateTimeToString;
import static it.euris.academy.webservicerest.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_order")
public class CustomerOrder implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name="customer_id", nullable=false)
  private Customer customer;

  @Column(name = "order_date", nullable=false)
  private LocalDateTime orderDate;

  @Column(name = "notes")
  private String notes;


  @Override
  public CustomerOrderDTO toDto() {
    return CustomerOrderDTO
        .builder()
        .id(numberToString(id))
        .orderDate(localDateTimeToString(orderDate))
        .notes(notes)
        .build();
  }

}
