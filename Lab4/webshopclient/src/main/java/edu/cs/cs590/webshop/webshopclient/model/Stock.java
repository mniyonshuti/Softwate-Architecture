package edu.cs.cs590.webshop.webshopclient.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Stock {
    int nrInStock;
    String locationCode;
}
