package it.euris.academy.webservicerest.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.webservicerest.data.dto.OrderDetailDTO;
import it.euris.academy.webservicerest.data.dto.archetype.Dto;
import it.euris.academy.webservicerest.data.dto.archetype.Model;
import it.euris.academy.webservicerest.data.entity.key.OrderDetailKey;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail implements Model {

  @EmbeddedId
  private OrderDetailKey id;

  @ManyToOne
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private CustomerOrder customerOrder;

  @ManyToOne
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "item_number")
  @Builder.Default
  private Integer itemNumber = 0;

  @Column(name="notes")
  private String notes;

  @Override
  public OrderDetailDTO toDto() {
    return OrderDetailDTO
        .builder()
        .customerOrderId(customerOrder==null ? null : customerOrder.getId().toString())
        .productId(product==null ? null : product.getId().toString())
        .itemNumber(numberToString(itemNumber))
        .notes(notes)
        .build();
  }
}
