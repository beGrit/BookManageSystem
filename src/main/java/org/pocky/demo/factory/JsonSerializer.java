package org.pocky.demo.factory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pocky.demo.dto.JsonResponse;

/**
 * Json 序列化工具
 */
public class JsonSerializer {
    public static String serialize(Integer code, String msg, Object data) throws JsonProcessingException {
        JsonResponse dto = new JsonResponse(code, msg, data);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);
        return json;
    }

    public static String serialize(Integer code, String message) throws JsonProcessingException {
        return serialize(code, message, null);
    }

    public static String serialize(JsonResponse jsonResponse) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(jsonResponse);
        return json;
    }
}
