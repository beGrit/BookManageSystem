package org.pocky.demo.service.book;

import org.pocky.demo.models.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.service.commons.KeyWordQueryService;

import java.util.List;

public interface KeyWordQueryBookService extends KeyWordQueryService {
    public List<Book> queryAllByKeyWord(String keyword) throws QueryPageFailedException;

    public Page<Book> queryPageByKeyword(String keyword, PageParam pageParam);
}
