package org.pocky.demo.service.impl;

import org.pocky.demo.beans.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageBar;
import org.pocky.demo.common.PageContentInfo;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.dao.BookDao;
import org.pocky.demo.dao.impl.BookDaoImpl;
import org.pocky.demo.exceptions.PageNotFoundException;
import org.pocky.demo.service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> queryAll() {
        try {
            List<Book> list = bookDao.findAll();
            if (list != null) {
                return list;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Book> queryDbByPage(PageParam pageParam) throws SQLException, PageNotFoundException {
        Integer pageIndex = pageParam.getPageIndex();
        Integer pageSize = pageParam.getPageSize();
        try {
            List<Book> data = bookDao.findByPage(pageIndex, pageSize);
            if (data.size() > 0) {
                Long totalRecords = bookDao.countTotalRecords();
                PageContentInfo<Book> content = new PageContentInfo<>(pageIndex, pageSize, data);
                PageBar<Book> pageBar = new PageBar<>(pageIndex, pageSize, totalRecords);
                Page<Book> page = new Page<>(content, pageBar);
                return page;
            } else {
                throw new PageNotFoundException();
            }
        } catch (SQLException sqlException) {
            System.out.println("数据库异常");
            throw sqlException;
        } catch (PageNotFoundException pageNotFoundException) {
            System.out.println("未找到相关的信息: 当前请求页为第 " + pageIndex + " 页");
            throw pageNotFoundException;
        }
    }

    @Override
    public void processPageQuery(HttpServletRequest req, HttpServletResponse resp) throws SQLException, PageNotFoundException {
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        if (pageSize == null) {
            pageSize = "6";
        }
        PageParam pageParam = new PageParam(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
        Page<Book> page = this.queryDbByPage(pageParam);
        req.setAttribute("pageContent", page.getPageContentInfo());
        req.setAttribute("pageBar", page.getPageBar());
    }
}
