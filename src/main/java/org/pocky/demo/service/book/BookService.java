package org.pocky.demo.service.book;

import org.pocky.demo.models.Book;
import org.pocky.demo.exceptions.bookstore.AddBookFailedException;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 书籍管理服务
 * 检索服务
 */
public interface BookService extends BookQueryService, BookAddService {
    public void processPageQuery(HttpServletRequest req, HttpServletResponse resp) throws QueryPageFailedException;
}