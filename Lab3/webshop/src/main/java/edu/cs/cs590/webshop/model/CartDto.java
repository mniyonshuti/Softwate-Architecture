package edu.cs.cs590.webshop.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDto {
    String cartId;
    String productnumber;
    int quantity;
}
