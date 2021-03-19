package org.pocky.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pocky.demo.dto.ResponseDto;

public class JsonResponseUtil {
    public static String response(Integer code, String message, Object data) throws JsonProcessingException {
        ResponseDto dto = new ResponseDto(code, message, data);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        return json;
    }

    public static String response(ResponseDto responseDto) throws JsonProcessingException {
        Integer code = responseDto.getCode();
        String message = responseDto.getMessage();
        Object data = responseDto.getData();
        String json = response(code, message, data);
        return json;
    }
}
