package org.pocky.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Integer id;
    private String name;
    private List<Book> bookList;
    private Map<String, String> map;
    private Place place;
}
