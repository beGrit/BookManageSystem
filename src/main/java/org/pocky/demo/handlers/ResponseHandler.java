package org.pocky.demo.handlers;

import javax.servlet.http.HttpServletResponse;

/***
 * 处理 response 的内容写入
 */
public interface ResponseHandler {
    /**
     * 写json数据到HttpServletResponse对象中
     * @param resp
     * @param json
     */
    void writeJson(HttpServletResponse resp, String json);
}
