package org.pocky.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JsonResponse {
    private Integer code;
    private String msg;
    private Object data;
}
