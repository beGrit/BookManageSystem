package org.pocky.demo.factory;

import org.pocky.demo.builders.PageBuilder;
import org.pocky.demo.common.Page;

import java.util.List;

public class PageFactory<T> {
    public Page<T> getPage(Integer pageIndex, Integer pageSize, Long totalRecords, List<T> data) {
        PageBuilder<T> pageBuilder = new PageBuilder<>();
        Page<T> page = pageBuilder.getResult(pageIndex, pageSize, totalRecords, data);
        return page;
    }
}
