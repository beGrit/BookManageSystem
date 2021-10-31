package org.pocky.demo.dao;

import org.junit.jupiter.api.Test;
import org.pocky.demo.models.Book;
import org.pocky.demo.dao.impl.BookDaoImpl;

import java.sql.SQLException;
import java.util.List;

class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    void findAll() throws SQLException {
        List<Book> bookList = bookDao.findAll();
        System.out.println(bookList);
    }

    @Test
    void findByPage() throws SQLException {
        List<Book> list = bookDao.findPage(1, 3);
        for (Book book : list) {
            System.out.println(book);
        }
    }

    @Test
    void countTotalRecords() throws SQLException {
        Long rtn = bookDao.countTotalRecords();
        System.out.println(rtn);
    }

    @Test
    void countTotalRecordsLimitKeyword() throws SQLException {
        long rtn = bookDao.countTotalRecordsLimitKeyword("数据库");
        System.out.println(rtn);
    }

    @Test
    void searchPageByKeywords() throws SQLException {
        List<Book> books = bookDao.searchPageByKeywords(1, 4, "数据库");
        System.out.println(books);
    }

    @Test
    void searchByKeywords() throws SQLException {
        /**
         * 关键字为 "数据库"
         */
        List<Book> list1 = bookDao.searchByKeywords("大学");
        System.out.println(list1);
        /**
         * 关键字为 ""
         */
        List<Book> list2 = bookDao.searchByKeywords("");
        System.out.println(list2);
        /**
         * 关键字为 "-__"
         */
        List<Book> list3 = bookDao.searchByKeywords("-__");
        System.out.println(list3);
    }

    @Test
    void testSearchPageByKeywords() throws SQLException {
        List<Book> list1 = bookDao.searchPageByKeywords(1, 2, "");
        System.out.println(list1);
    }

    @Test
    void batchDelete() throws SQLException {
        Object[][] idList = new Object[2][];
        idList[0] = new Object[1];
        idList[0][0] = "b03";
        idList[1] = new Object[1];
        idList[1][0] = "b04";
        int[] ints = bookDao.batchDelete(idList);
        System.out.println(ints);
    }

}