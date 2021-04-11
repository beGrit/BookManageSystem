package org.pocky.demo.service;

import org.pocky.demo.handlers.ResponseHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseService {

    ResponseHandler responseHandler = new ResponseHandler() {
        @Override
        public void writeJson(HttpServletResponse resp, String json) {
            resp.setContentType("json");
            try {
                resp.getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };


}
