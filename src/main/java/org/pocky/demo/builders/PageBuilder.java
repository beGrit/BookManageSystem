package org.pocky.demo.builders;

import org.pocky.demo.common.Page;
import org.pocky.demo.common.PageBar;
import org.pocky.demo.common.PageContentInfo;

import java.util.List;

public class PageBuilder<T> {
    public Page<T> getResult(Integer pageIndex, Integer pageSize, Long totalRecords, List<T> data) {
        Page<T> page = new Page<>();
        this.buildPageInfo(page, pageIndex, pageSize, data);
        this.buildPageBar(page, pageIndex, pageSize, totalRecords);
        return page;
    }

    public void buildPageInfo(Page<T> page, Integer curPageIndex, Integer pageSize, List<T> data) {
        PageContentInfo<T> pageContentInfo = new PageContentInfo<>(curPageIndex, pageSize, data);
        page.setPageContentInfo(pageContentInfo);
    }

    public void buildPageBar(Page<T> page, Integer curPageIndex, Integer pageSize, Long totalRecords) {
        PageBar pageBar = new PageBar(curPageIndex, pageSize, totalRecords);
        page.setPageBar(pageBar);
    }
}
