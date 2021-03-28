package org.pocky.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private PageContentInfo<T> pageContentInfo;
    private PageBar<T> pageBar;
}
