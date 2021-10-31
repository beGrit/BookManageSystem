package org.pocky.demo.tests;

import org.pocky.demo.models.Book;
import org.pocky.demo.models.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonFactory {
    public static Person getInstance() {
        Person person = new Person();

        Book book1 = new Book("b01", "", "", 0.0, "", 1, 1);
        Book book2 = new Book("b02", "", "", 0.0, "", 1, 1);
        Book book3 = new Book("b03", "", "", 0.0, "", 1, 1);
        Book book4 = new Book("b04", "", "", 0.0, "", 1, 1);

        ArrayList<Book> books = new ArrayList<>();

        books.add(book1);
        books.add(book2);
        books.add(book3);

        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");

        person.setName("lsf");
        person.setBookList(books);
        person.setMap(map);

        return person;
    }
}
