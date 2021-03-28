package org.pocky.demo.dao;

import org.junit.jupiter.api.Test;
import org.pocky.demo.beans.Book;
import org.pocky.demo.dao.impl.BookDaoImpl;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    void findByPage() throws SQLException {
        List<Book> list = bookDao.findByPage(10, 4);
        for (Book book : list) {
            System.out.println(book);
        }
    }

    @Test
    void countTotalRecords() throws SQLException {
        Long rtn = bookDao.countTotalRecords();
        System.out.println(rtn);
    }
}