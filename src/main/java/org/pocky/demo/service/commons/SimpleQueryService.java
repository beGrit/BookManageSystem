package org.pocky.demo.service.commons;

import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageParam;
import org.pocky.demo.exceptions.bookstore.QueryFailedException;
import org.pocky.demo.exceptions.bookstore.QueryPageFailedException;

import java.util.List;

public interface SimpleQueryService {
//    Object queryOneById(String id);

    Object queryOneById(String id) throws QueryFailedException;

    List queryAll() throws QueryFailedException;
}
