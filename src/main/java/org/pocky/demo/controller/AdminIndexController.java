package org.pocky.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminPageIndexController", value = {"/admin/index"})
public class AdminIndexController extends BaseController {
    public void mainView(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void welcomeView(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
