package org.pocky.demo.controller.index;

import org.pocky.demo.controller.BaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommonIndexController", value = {"/common/index"})
public class CommonIndexController extends BaseController {

    /**
     * 进入登录页面
     *
     * @param req
     * @param resp
     */
    public void loginView(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
