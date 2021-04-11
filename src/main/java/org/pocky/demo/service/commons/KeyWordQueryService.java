package org.pocky.demo.service.commons;

import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;

import java.util.List;

public interface KeyWordQueryService {
    public List queryAllByKeyWord(String keyword) throws QueryPageFailedException;

    public Page queryPageByKeyword(String keyword, PageParam pageParam);
}
