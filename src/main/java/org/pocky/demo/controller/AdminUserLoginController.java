package org.pocky.demo.controller;

import com.google.gson.Gson;
import org.pocky.demo.beans.AdminUser;
import org.pocky.demo.dto.ResponseDto;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminController", value = "/admin/admin")
public class AdminUserLoginController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = (String) req.getAttribute("username");
        String password = (String) req.getAttribute("password");
        try {
            AdminUser adminUser = adminUserService.login(username, password);
            try {
                PrintWriter writer = resp.getWriter();
                Gson gson = new Gson();
                String data = gson.toJson(adminUser);
                writer.print(data);
//                ResponseDto responseDto = new ResponseDto(200, "恭喜登录成功");
//                new Jackson2ObjectMapperBuilder();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (AuthenticationFailException e) {
            try {
                req.getRequestDispatcher("/login").forward(req, resp);
            } catch (ServletException servletException) {
                servletException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
