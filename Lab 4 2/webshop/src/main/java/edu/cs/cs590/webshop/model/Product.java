package edu.cs.cs590.webshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    @Id
    String productNumber;
    String description;
    double price;
    Review review;
    Supplier supplier;
    Stock stock;
}
