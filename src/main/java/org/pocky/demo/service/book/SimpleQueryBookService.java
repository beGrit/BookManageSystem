package org.pocky.demo.service.book;

import org.pocky.demo.exceptions.bookstore.QueryFailedException;
import org.pocky.demo.models.Book;
import org.pocky.demo.service.commons.SimpleQueryService;

import java.util.List;

public interface SimpleQueryBookService extends SimpleQueryService {
    /**
     * 根据ID查询单本书籍信息
     * @param id
     * @return
     */
    @Override
    Book queryOneById(String id) throws QueryFailedException;

    /**
     * 查询所有书籍
     * @return
     */
    @Override
    List<Book> queryAll() throws QueryFailedException;
}
