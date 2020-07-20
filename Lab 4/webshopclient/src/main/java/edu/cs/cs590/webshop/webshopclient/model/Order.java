package edu.cs.cs590.webshop.webshopclient.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    String orderNumber;
    boolean orderStatus;
    LocalDate date;
    List<OrderLine> orderLineList;
}
