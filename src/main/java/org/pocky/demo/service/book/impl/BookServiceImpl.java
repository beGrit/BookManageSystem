package org.pocky.demo.service.book.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.pocky.demo.exceptions.bookstore.DeleteBookException;
import org.pocky.demo.factory.JsonSerializer;
import org.pocky.demo.models.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.dao.BookDao;
import org.pocky.demo.dao.impl.BookDaoImpl;
import org.pocky.demo.exceptions.PageNotFoundException;
import org.pocky.demo.exceptions.bookstore.AddBookFailedException;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.exceptions.bookstore.SearchParamsError;
import org.pocky.demo.factory.PageFactory;
import org.pocky.demo.service.book.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


// QueryBookService

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public Book queryOneById(String id) {
        return null;
    }

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
    public Page<Book> queryByPageParam(PageParam pageParam) throws QueryPageFailedException {
        Integer pageIndex = pageParam.getPageIndex();
        Integer pageSize = pageParam.getPageSize();
        try {
            List<Book> data = bookDao.findPage(pageIndex, pageSize);
            if (data != null && data.size() > 0) {
                Long totalRecords = bookDao.countTotalRecords();
                return new PageFactory<Book>().getPage(pageIndex, pageSize, totalRecords, data);
            } else {
                throw new PageNotFoundException();
            }
        } catch (SQLException sqlException) {
            System.out.println("???????????????");
            throw new QueryPageFailedException();
        } catch (PageNotFoundException pageNotFoundException) {
            System.out.println("????????????????????????: ????????????????????? " + pageIndex + " ???");
            throw new QueryPageFailedException();
        }
    }

    @Override
    public List<Book> queryAllByKeyWord(String keyword) throws QueryPageFailedException {
        if (keyword == null || keyword.equals("")) {
            throw new SearchParamsError();
        } else {
            try {
                List<Book> bookList = bookDao.searchByKeywords(keyword);
                if (bookList == null || bookList.size() == 0) {
                    throw new QueryPageFailedException();
                }
                int totalRecords = bookList.size();
                return bookList;
            } catch (QueryPageFailedException e) {
                // ???????????????
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Page<Book> queryPageByKeyword(String keyword, PageParam pageParam) {
        if (keyword == null || keyword.equals("")) {
            throw new SearchParamsError();
        } else {
            try {
                Integer pageIndex = pageParam.getPageIndex();
                Integer pageSize = pageParam.getPageSize();
                List<Book> books = bookDao.searchPageByKeywords(pageIndex, pageSize, keyword);
                long count = bookDao.countTotalRecordsLimitKeyword(keyword);
                return new PageFactory<Book>().getPage(pageIndex, pageSize, count, books);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void addOneBook(Book book) throws AddBookFailedException {
        int count = 0;
        try {
            count = bookDao.insertOneBook(book);
            if (count != 1) {
                throw new AddBookFailedException();
            }
            // response
        } catch (SQLException e) {
            System.out.println("SQLException...");
        } catch (AddBookFailedException e) {
            System.out.println("Add failed...");
            // ??????????????????
            throw new AddBookFailedException();
        }
    }

    public void processPageQuery(HttpServletRequest req, HttpServletResponse resp) throws QueryPageFailedException {
        String pageIndex = req.getParameter("pageIndex");
        String pageSize = req.getParameter("pageSize");
        if (pageSize == null) {
            pageSize = "6";
        }
        PageParam pageParam = new PageParam(Integer.parseInt(pageIndex), Integer.parseInt(pageSize));
        Page<Book> page = this.queryByPageParam(pageParam);
        req.setAttribute("pageContent", page.getPageContentInfo());
        req.setAttribute("pageBar", page.getPageBar());
    }

    public void deleteByIdList(List<String> idList) throws DeleteBookException {
        int length = idList.size();
        Object[][] params = new Object[idList.size()][];
        Object[] ids = idList.toArray();
        for (int i = 0; i < length; i++) {
            params[i] = new Object[1];
            params[i][0] = ids[i];
        }
        try {
            int[] rtns = bookDao.batchDelete(params);
            for (int rtn : rtns) {
                if (rtn == 0) {
                    throw new DeleteBookException();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new DeleteBookException();
        }
    }

    // ???Response????????????
    public void json(HttpServletRequest req, HttpServletResponse resp, Object data) {
        try {
            String json = JsonSerializer.serialize(200, "??????", data);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().write(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// ???????????????

// ??????resp

// ??????????????????????????????json

// ????????????????????????resp
