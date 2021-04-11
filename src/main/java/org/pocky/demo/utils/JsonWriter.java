package org.pocky.demo.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface JsonWriter {
    // 提供 json -> response服务
    public void write(HttpServletResponse resp, String json) throws IOException;
}
