package org.pocky.demo.common;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PageBar {
    private Integer curPageIndex;
    private Integer prePageIndex;
    private Integer nextPageIndex;
    private Integer lastPageIndex;
    private Long totalRecords;
    private Integer totalPages;
    private List<Integer> declaredIndexList;

    public PageBar(Integer curPageIndex, Integer pageSize, Long totalRecords) {
        this.curPageIndex = curPageIndex;
        this.totalRecords = totalRecords;
        this.lastPageIndex = (int) Math.ceil(totalRecords / (pageSize + 1.0));
        this.prePageIndex = curPageIndex.equals(1) ? curPageIndex : curPageIndex - 1;
        this.nextPageIndex = curPageIndex.equals(this.lastPageIndex) ? curPageIndex : curPageIndex + 1;
        this.totalPages = lastPageIndex;
        this.declaredIndexList = new ArrayList<>();
        if (totalPages < 5) {
            for (int i = 1; i <= totalPages; i++) {
                declaredIndexList.add(i);
            }
        } else {
            // 实现totalPages > 5时, 压缩成 5个索引
        }
    }
}
