package edu.cs.cs590.webshop.webshopclient.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    String productNumber;
    String description;
    double price;
    Review review;
    Supplier supplier;
    Stock stock;
}
