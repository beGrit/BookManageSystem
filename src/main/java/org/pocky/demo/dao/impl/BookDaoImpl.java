package org.pocky.demo.dao.impl;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.pocky.demo.dao.BaseDao;
import org.pocky.demo.dao.BookDao;

import org.pocky.demo.beans.Book;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    public List<Book> findAll() throws SQLException {
        String sql = "select * from book";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class, rowProcessor));
        return list;
    }

    @Override
    public List<Book> findByPage(Integer pageIndex, Integer pageSize) throws SQLException {
        String sql = "select * from book order by bno limit ?,?";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class, rowProcessor), (pageIndex - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public Long countTotalRecords() throws SQLException {
        String sql = "select count(*) from book";
        int rtn = queryRunner.query(sql, resultSet -> {
            resultSet.next();
            return resultSet.getInt("count(*)");
        });
        return Long.valueOf(rtn);
    }
}
