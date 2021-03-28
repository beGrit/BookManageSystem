package org.pocky.demo.common;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageContentInfo<T> {
    private Integer curPageIndex;
    private Integer pageSize;
    private List<T> data;
}
