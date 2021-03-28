package org.pocky.demo.dao;

import org.pocky.demo.beans.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    public List<Book> findAll() throws SQLException;

    public List<Book> findByPage(Integer i, Integer pageSize) throws SQLException;

    public Long countTotalRecords() throws SQLException;
}
