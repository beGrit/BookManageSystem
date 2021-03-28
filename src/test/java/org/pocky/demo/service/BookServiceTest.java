package org.pocky.demo.service;

import org.junit.jupiter.api.Test;
import org.pocky.demo.beans.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageContentInfo;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.PageNotFoundException;
import org.pocky.demo.service.impl.BookServiceImpl;

import java.sql.SQLException;

class BookServiceTest {

    BookService bookService = new BookServiceImpl();

    @Test
    void queryAll() {
    }

    @Test
    void pageQuery() throws PageNotFoundException, SQLException {
        Page<Book> pageContentInfo = bookService.queryDbByPage(new PageParam(5, 4));
        System.out.println(pageContentInfo);
    }
}