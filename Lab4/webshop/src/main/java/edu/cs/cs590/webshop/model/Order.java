package edu.cs.cs590.webshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    @Id
    String orderNumber;
    boolean orderStatus;
    LocalDate date;
    List<OrderLine> orderLineList;
}
