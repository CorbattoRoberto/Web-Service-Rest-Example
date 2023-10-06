package it.euris.academy.webservicerest.data.dto;

import it.euris.academy.webservicerest.data.dto.archetype.Dto;
import it.euris.academy.webservicerest.data.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.stringToBigDecimal;
import static it.euris.academy.webservicerest.utility.DataConversionUtils.stringToInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductDTO implements Dto {

  private String id;

  private String name;

  private String description;

  private String price;

  private String inStock;

  @Override
  public Product toModel() {
    return Product
        .builder()
        .id(stringToInteger(id))
        .name(name)
        .description(description)
        .price(stringToBigDecimal(price))
        .build();
  }
}
