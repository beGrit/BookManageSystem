package org.pocky.demo.service;

import org.junit.jupiter.api.Test;
import org.pocky.demo.models.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.service.book.BookService;
import org.pocky.demo.service.book.impl.BookServiceImpl;

import java.util.List;

class BookServiceTest {

    BookService bookService = new BookServiceImpl();

    @Test
    void queryAll() {
    }

    @Test
    void pageQuery() {
        Page<Book> pageContentInfo = null;
        try {
            pageContentInfo = bookService.queryByPageParam(new PageParam(5, 4));
            System.out.println(pageContentInfo);
        } catch (QueryPageFailedException e) {
            // 请求失败错误处理
            e.printStackTrace();
        }
    }

    @Test
    void queryAllByKeyWord() throws QueryPageFailedException {
        List<Book> books = bookService.queryAllByKeyWord("数据库");
        System.out.println(books);
    }

    @Test
    void queryPageByKeyword() {

    }
}