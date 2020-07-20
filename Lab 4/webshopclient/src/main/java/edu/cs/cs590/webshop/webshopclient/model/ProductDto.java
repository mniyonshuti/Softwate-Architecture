package edu.cs.cs590.webshop.webshopclient.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
    String cartId;
    String productNumber;
    int quantity;
}
