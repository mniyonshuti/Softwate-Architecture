package edu.cs.cs590.webshop.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Review {
    String tittle;
    String description;
    double score;
}
