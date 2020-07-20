package edu.cs.cs590.webshop.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    String street;
    String city;
    String zip;
    String country;
}
