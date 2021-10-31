package org.pocky.demo.service.book;

import org.junit.jupiter.api.Test;
import org.pocky.demo.exceptions.bookstore.DeleteBookException;
import org.pocky.demo.service.book.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDeleteServiceTest {
    BookDeleteService bookDeleteService = new BookServiceImpl();

    @Test
    void deleteByIdList() throws DeleteBookException {
        List<String> list = new ArrayList<String>();
        list.add("b06");
        list.add("b07");
        bookDeleteService.deleteByIdList(list);
        System.out.println();
    }
}