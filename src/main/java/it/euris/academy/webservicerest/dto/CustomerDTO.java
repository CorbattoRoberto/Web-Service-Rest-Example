package it.euris.academy.webservicerest.dto;

import it.euris.academy.webservicerest.dto.archetype.Dto;
import it.euris.academy.webservicerest.dto.archetype.Model;
import it.euris.academy.webservicerest.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO implements Dto {

  private Integer id;

  private String firstName;

  private String lastName;

  private String address;

  private String city;

  private String email;

  private String notes;

  @Override
  public Model toModel() {

    return Customer
        .builder()
        .firstName(firstName)
        .lastName(lastName)
        .address(address)
        .city(city)
        .email(email)
        .notes(notes)
        .build();
  }

}
