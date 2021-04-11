package org.pocky.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private PageContentInfo<T> pageContentInfo;
    private PageBar pageBar;
}
// 聚合 组合 关联