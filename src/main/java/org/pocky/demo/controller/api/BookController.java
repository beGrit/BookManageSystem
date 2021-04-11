package org.pocky.demo.controller.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.controller.BaseController;
import org.pocky.demo.exceptions.bookstore.QueryFailedException;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.factory.JsonSerializer;
import org.pocky.demo.models.Book;
import org.pocky.demo.proxy.JsonBookServiceProxy;
import org.pocky.demo.service.book.BookQueryService;
import org.pocky.demo.service.book.BookService;
import org.pocky.demo.service.book.impl.BookServiceImpl;
import org.pocky.demo.utils.JsonWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApiBookController", urlPatterns = {"/admin/api/book"})
public class BookController extends BaseController {

    BookQueryService bookService = new JsonBookServiceProxy();

    JsonWriter jsonWriter = new JsonWriter() {
        @Override
        public void write(HttpServletResponse resp, String json) throws IOException {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().write(json);
        }
    };

    public void allBook(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Book> books = bookService.queryAll();
            String json = JsonSerializer.serialize(200, "成功", books);
            jsonWriter.write(resp, json);
        } catch (QueryFailedException e) {
            System.out.println("请求失败");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * path: m=pageBook&pageIndex=1&pageSize=5
     * @param req
     * @param resp
     */
    public void pageBook(HttpServletRequest req, HttpServletResponse resp) {
        Integer pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));
        PageParam param = new PageParam(pageIndex, pageSize);
        try {
            JsonBookServiceProxy jsonBookServiceProxy = (JsonBookServiceProxy) bookService;
            jsonBookServiceProxy.setResponse(resp);
            Page<Book> page = bookService.queryByPageParam(param);
//            String json = JsonSerializer.serialize(200, "成功", page);
//            jsonWriter.write(resp, json);
        } catch (QueryPageFailedException e) {
            e.printStackTrace();
        }
    }
}
