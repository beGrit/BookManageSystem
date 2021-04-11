package org.pocky.demo.service.commons;

import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;

public interface PageQueryService {
    Page queryByPageParam(PageParam pageParam) throws QueryPageFailedException;
}
