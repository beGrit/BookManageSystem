package org.pocky.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDto {
    private Integer code;
    private String message;
    private Object data;
}
