package it.euris.academy.webservicerest.data.dto;

import it.euris.academy.webservicerest.data.dto.archetype.Dto;
import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import it.euris.academy.webservicerest.utility.EntityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderDTO implements Dto {

  private String id;

  private String customerId;

  private String orderDate;

  private String shipmentType;

  private String notes;

  @Override
  public CustomerOrder toModel() {
    return CustomerOrder
        .builder()
        .id(stringToInteger(id))
        .customer(EntityUtils.getCustomer(stringToInteger(customerId)))
        .orderDate(stringToLocalDateTime(orderDate))
        .shipmentType(stringToShipmentType(shipmentType))
        .notes(notes)
        .build();
  }
}
