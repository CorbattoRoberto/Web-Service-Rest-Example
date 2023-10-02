package it.euris.academy.webservicerest.dto;

import it.euris.academy.webservicerest.dto.archetype.Dto;
import it.euris.academy.webservicerest.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.stringToInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements Dto {

  private String id;

  private String firstName;

  private String lastName;

  private String address;

  private String city;

  private String email;

  private String notes;

  @Override
  public Customer toModel() {

    return Customer
        .builder()
        .id(stringToInteger(id))
        .firstName(firstName)
        .lastName(lastName)
        .address(address)
        .city(city)
        .email(email)
        .notes(notes)
        .build();
  }

}
