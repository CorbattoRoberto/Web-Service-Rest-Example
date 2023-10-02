package it.euris.academy.webservicerest.entity;

import it.euris.academy.webservicerest.dto.CustomerDTO;
import it.euris.academy.webservicerest.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.numberToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer implements Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "first_name" , nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "notes")
  private String notes;

  @Column(name = "active")
  @Builder.Default
  private Boolean active = true;

  @Override
  public CustomerDTO toDto() {
    return CustomerDTO
        .builder()
        .id(numberToString(id))
        .firstName(firstName)
        .lastName(lastName)
        .address(address)
        .city(city)
        .email(email)
        .notes(notes)
        .build();
  }

}

