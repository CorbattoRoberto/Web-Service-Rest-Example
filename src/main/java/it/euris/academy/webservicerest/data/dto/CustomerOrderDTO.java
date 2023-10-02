package it.euris.academy.webservicerest.data.dto;

import it.euris.academy.webservicerest.data.dto.archetype.Dto;
import it.euris.academy.webservicerest.data.entity.CustomerOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.stringToInteger;
import static it.euris.academy.webservicerest.utility.DataConversionUtils.stringToLocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderDTO implements Dto {

  private String id;

  private String orderDate;

  private String notes;

  @Override
  public CustomerOrder toModel() {
    return CustomerOrder
        .builder()
        .id(stringToInteger(id))
        .orderDate(stringToLocalDateTime(orderDate))
        .notes(notes)
        .build();
  }
}
