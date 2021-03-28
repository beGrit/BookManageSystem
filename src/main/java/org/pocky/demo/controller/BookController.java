package org.pocky.demo.controller;

import org.pocky.demo.exceptions.PageNotFoundException;
import org.pocky.demo.service.BookService;
import org.pocky.demo.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BookController", urlPatterns = {"/admin/book"})
public class BookController extends BaseController {
    BookService bookService = new BookServiceImpl();

    public void bookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            bookService.processPageQuery(req, resp);
            req.getRequestDispatcher("/WEB-INF/views/book/book-list.jsp").forward(req, resp);
        } catch (PageNotFoundException | SQLException pageNotFoundException) {
            req.getRequestDispatcher("/WEB-INF/views/commons/DatabaseErrorPage.jsp");
        }
    }
}
