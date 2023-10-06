package it.euris.academy.webservicerest.data.dto;


import it.euris.academy.webservicerest.data.dto.archetype.Dto;
import it.euris.academy.webservicerest.data.dto.archetype.Model;
import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import it.euris.academy.webservicerest.data.entity.OrderDetail;
import it.euris.academy.webservicerest.data.entity.Product;
import it.euris.academy.webservicerest.data.entity.key.OrderDetailKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.stringToInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO implements Dto {

  private String productId;

  private String customerOrderId;

  private String itemNumber;

  private String notes;

  @Override
  public OrderDetail toModel() {
    return OrderDetail
        .builder()
        .id(new OrderDetailKey(stringToInteger(customerOrderId), stringToInteger(productId)))
        .customerOrder(CustomerOrder.builder().id(stringToInteger(customerOrderId)).build())
        .product(Product.builder().id(stringToInteger(productId)).build())
        .itemNumber(stringToInteger(itemNumber))
        .notes(notes)
        .build();
  }
}
