package edu.cs.cs590.webshop.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StockDto {
    String productNumber;
    int nrInStock;
    String locationCode;
}
