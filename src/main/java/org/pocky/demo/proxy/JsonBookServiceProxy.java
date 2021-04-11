package org.pocky.demo.proxy;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryFailedException;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.factory.JsonSerializer;
import org.pocky.demo.models.Book;
import org.pocky.demo.service.book.BookQueryService;
import org.pocky.demo.service.book.BookService;
import org.pocky.demo.service.book.impl.BookServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JsonBookServiceProxy implements BookQueryService {
    BookServiceImpl realBookService = new BookServiceImpl();
    HttpServletResponse resp = null;

    public JsonBookServiceProxy() {
    }

    // 前置操作
    private void preOperate() {

    }

    // 后置操作
    private void postOperate(Object data) throws QueryPageFailedException {
        try {
            String json = JsonSerializer.serialize(200, "成功", data);
            this.resp.setContentType("application/json");
            this.resp.setCharacterEncoding("utf-8");
            this.resp.getWriter().write(json);
        } catch (JsonProcessingException e) {
            throw new QueryPageFailedException();
        } catch (IOException e) {
            throw new QueryPageFailedException();
        }
    }

    // 依赖Response对象
    public void setResponse(HttpServletResponse resp) {
        this.resp = resp;
    }

    @Override
    public List<Book> queryAllByKeyWord(String keyword) throws QueryPageFailedException {
        return null;
    }

    @Override
    public Page<Book> queryPageByKeyword(String keyword, PageParam pageParam) {
        return null;
    }

    @Override
    public Page<Book> queryByPageParam(PageParam pageParam) throws QueryPageFailedException {
        Page<Book> page = this.realBookService.queryByPageParam(pageParam);
        postOperate(page);
        return page;
    }

    @Override
    public Book queryOneById(String id) throws QueryFailedException {
        return null;
    }

    @Override
    public List<Book> queryAll() throws QueryFailedException {
        List<Book> books = this.realBookService.queryAll();
        return books;
    }
}
