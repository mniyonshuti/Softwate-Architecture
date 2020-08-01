package edu.cs.cs590.webshop.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Supplier {
    int supplierNumber;
    String name;
    String phone;
    String email;
    Address address;
}
