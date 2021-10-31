package org.pocky.demo.dao.impl;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.pocky.demo.dao.BaseDao;
import org.pocky.demo.dao.BookDao;

import org.pocky.demo.models.Book;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    public List<Book> findAll() throws SQLException {
        String sql = "select * from book where is_valid = 1";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class, rowProcessor));
        return list;
    }

    @Override
    public List<Book> findPage(Integer pageIndex, Integer pageSize) throws SQLException {
        String sql = "select * from book where is_valid = 1 order by bno limit ?,?";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class, rowProcessor), (pageIndex - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public Long countTotalRecords() throws SQLException {
        String sql = "select count(*) from book where is_valid = 1";
        int rtn = queryRunner.query(sql, resultSet -> {
            resultSet.next();
            return resultSet.getInt("count(*)");
        });
        return Long.valueOf(rtn);
    }

    public List<Book> searchByKeywords(String keyword) throws SQLException {
        String sql = "";
        sql = "select distinct * from book where " +
                "bname like concat('%', ?, '%') " +
                "or " +
                "author like concat('%', ?, '%') ";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class, rowProcessor), keyword, keyword);
        return list;
    }

    @Override
    public List<Book> searchPageByKeywords(Integer pageIndex, Integer pageSize, String keyword) throws SQLException {
        String sql = "";
        sql = "select distinct * from book where " +
                "bname like concat('%', ?, '%') " +
                "or " +
                "author like concat('%', ?, '%') " +
                "limit ?,?";
        List<Book> list = queryRunner.query(sql, new BeanListHandler<>(Book.class, rowProcessor), keyword, keyword, (pageIndex - 1) * pageSize, pageSize);
        return list;
    }

    public Long countTotalRecordsLimitKeyword(String keyword) throws SQLException {
        String sql = "select count(*) from book where bname like concat('%', ?, '%') or author like concat('%', ?, '%')";
        int rtn = queryRunner.query(sql, resultSet -> {
            resultSet.next();
            return resultSet.getInt("count(*)");
        }, keyword, keyword);
        return Long.valueOf(rtn);
    }

    @Override
    public int insertOneBook(Book book) throws SQLException {
        String sql = "insert into book" +
                "set" +
                "bno = ?, bname = ?, author = ?, author = ?, price = ?, publish = ?, bookNumber = ?";
        String sql2 = "insert into book " +
                "set " + "bno = ?";
        String bno = book.getBno();
        String bname = book.getBname();
        int rtn = queryRunner.execute(sql2, bno);
        return rtn;
    }

    public int deleteByIdList(List<Integer> idList) throws SQLException {
        String sql = "delete * from book where bno in (?)";
        return 0;
    }

    @Override
    public int[] batchDelete(Object[][] params) throws SQLException {
        String sql = "update book set is_valid = 0 where bno = ?";
        int[] rtn = queryRunner.batch(sql, params);
        return rtn;
    }
}
