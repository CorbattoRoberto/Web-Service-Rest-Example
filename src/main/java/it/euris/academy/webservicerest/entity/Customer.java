package it.euris.academy.webservicerest.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  Integer id;

  @Column(name = "first_name" , nullable = false)
  String firstName;

  @Column(name = "last_name", nullable = false)
  String lastName;

  @Column(name = "address", nullable = false)
  String address;

  @Column(name = "city", nullable = false)
  String city;

  @Column(name = "email", nullable = false)
  String email;

  @Column(name = "notes")
  String notes;

}

