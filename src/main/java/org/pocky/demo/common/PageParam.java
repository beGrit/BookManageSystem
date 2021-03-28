package org.pocky.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageParam {
    private Integer pageIndex;
    private Integer pageSize;
}
