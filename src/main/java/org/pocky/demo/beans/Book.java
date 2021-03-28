package org.pocky.demo.beans;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {
    private String bno;
    private String bname;
    private String author;
    private Double price;
    private String publish;
    private int bookNumber;
}