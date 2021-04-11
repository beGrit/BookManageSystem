package org.pocky.demo.dao;

import org.pocky.demo.models.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    /**
     * 检索所有的书籍
     * @return
     * @throws SQLException
     */
    public List<Book> findAll() throws SQLException;

    /**
     * 检索某一页的书籍
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<Book> findPage(Integer pageIndex, Integer pageSize) throws SQLException;


    public List<Book> searchByKeywords(String keyword) throws SQLException;

    public List<Book> searchPageByKeywords(Integer pageIndex, Integer pageSize, String keyword) throws SQLException;

    /**
     * 数量: 所有书籍
     * @return
     * @throws SQLException
     */
    public Long countTotalRecords() throws SQLException;

    /**
     * 数量: 包含关键字的书籍
     * @param keyword
     * @return
     * @throws SQLException
     */
    public Long countTotalRecordsLimitKeyword(String keyword) throws SQLException;

    public int insertOneBook(Book book) throws SQLException;
}
