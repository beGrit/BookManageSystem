package org.pocky.demo.service.book;

import org.junit.jupiter.api.Test;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.models.Book;
import org.pocky.demo.service.book.impl.BookServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class PageQueryBookServiceTest {

    PageQueryBookService service = new BookServiceImpl();

    @Test
    void queryByPageParam() {
        PageParam param = new PageParam(0, 3);
        try {
            Page<Book> page = service.queryByPageParam(param);
            System.out.println();
        } catch (QueryPageFailedException e) {
            e.printStackTrace();
        }
    }
}