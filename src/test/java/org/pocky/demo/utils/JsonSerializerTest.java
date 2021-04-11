package org.pocky.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.pocky.demo.factory.JsonSerializer;

class JsonSerializerTest {

    @Test
    void response() throws JsonProcessingException {
        String json = JsonSerializer.serialize(200, "成功");
        System.out.println(json);
    }

    @Test
    void testResponse() {
    }

    @Test
    void testResponse1() {
    }
}