package org.pocky.demo.service;

import org.pocky.demo.beans.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageContentInfo;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.PageNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface BookService {
    public List<Book> queryAll();

    public Page<Book> queryDbByPage(PageParam pageParam) throws SQLException, PageNotFoundException;

    public void processPageQuery(HttpServletRequest req, HttpServletResponse resp) throws SQLException, PageNotFoundException;
}
