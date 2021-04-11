package org.pocky.demo.controller;

import org.pocky.demo.models.Book;
import org.pocky.demo.exceptions.bookstore.AddBookFailedException;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.service.book.BookService;
import org.pocky.demo.service.book.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "BookController", urlPatterns = {"/admin/book"})
public class BookController extends BaseController {
    BookService bookService = new BookServiceImpl();

    public void bookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            bookService.processPageQuery(req, resp);
            req.getRequestDispatcher("/WEB-INF/views/book/book-list.jsp").forward(req, resp);
        } catch (QueryPageFailedException e) {
            e.printStackTrace();
        }
    }

    public void addBook(HttpServletRequest req, HttpServletResponse resp) {
//        Date date = (Date) ConvertUtils.convert(req.getParameter(""), Date.class);
        Map<String, String[]> map = req.getParameterMap();
        Book book = new Book();
        book.setBno(req.getParameter("bno"));
        try {
            bookService.addOneBook(book);
            // 添加成功后的操作

        } catch (AddBookFailedException e) {
            // 添加失败后的操作
        }
    }
}
