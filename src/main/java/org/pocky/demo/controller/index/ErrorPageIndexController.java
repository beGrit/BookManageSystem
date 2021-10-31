package org.pocky.demo.controller.index;

import org.pocky.demo.controller.BaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/error/index"})
public class ErrorPageIndexController extends BaseController {
    public void handler500(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 转发到 500.jsp 页面
        req.getRequestDispatcher("/WEB-INF/views/errors/500.jsp").forward(req, resp);
    }

    public void handler404(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 转发到 500.jsp 页面
        req.getRequestDispatcher("/WEB-INF/views/errors/404.jsp").forward(req, resp);
    }
}
