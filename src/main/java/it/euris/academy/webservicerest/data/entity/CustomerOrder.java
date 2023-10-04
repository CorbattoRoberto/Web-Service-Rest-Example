package it.euris.academy.webservicerest.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.webservicerest.data.dto.CustomerOrderDTO;
import it.euris.academy.webservicerest.data.dto.archetype.Model;
import it.euris.academy.webservicerest.data.enums.ShipmentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.*;

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

  @Column(name = "shipment_type")
  @Enumerated(EnumType.STRING)
  private ShipmentType shipmentType;

  @Column(name = "notes")
  private String notes;

  @OneToMany(mappedBy = "customerOrder", fetch = FetchType.EAGER)
  @JsonIgnore
  @Builder.Default
  private List<OrderDetail> orderDetails = new ArrayList<>();

  @Override
  public CustomerOrderDTO toDto() {
    return CustomerOrderDTO
        .builder()
        .id(numberToString(id))
        .customerId(numberToString(customer.getId()))
        .orderDate(localDateTimeToString(orderDate))
        .shipmentType(shipmentTypeToString(shipmentType))
        .notes(notes)
        .build();
  }

}
