package org.pocky.demo.service.book;

import org.pocky.demo.models.Book;
import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;
import org.pocky.demo.service.commons.PageQueryService;

public interface PageQueryBookService extends PageQueryService {
    /**
     * 根据分页的参数表,查询该页数据
     *
     * @param pageParam
     * @return
     * @throws QueryPageFailedException
     */
    @Override
    Page<Book> queryByPageParam(PageParam pageParam) throws QueryPageFailedException;
}
