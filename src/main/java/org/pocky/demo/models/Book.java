package org.pocky.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bno;
    private String bname;
    private String author;
    private Double price;
    private String publish;
    private int bookNumber;
    private int isValid;
}