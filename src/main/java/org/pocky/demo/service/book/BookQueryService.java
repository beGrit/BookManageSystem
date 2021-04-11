package org.pocky.demo.service.book;

import org.pocky.demo.service.commons.QueryService;

/**
 * 书籍查询服务
 * Basic简单查询
 * Page分页查询
 * Keyword关键字检索查询
 */
public interface BookQueryService extends QueryService, SimpleQueryBookService, PageQueryBookService, KeyWordQueryBookService {
}
