package org.pocky.demo.controller;

import org.pocky.demo.dto.ResponseDto;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.exceptions.UpdateFailedException;
import org.pocky.demo.service.AdminUserService;
import org.pocky.demo.service.impl.AdminUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminController", value = "/common/login")
public class AdminUserLoginController extends BaseController {

    private AdminUserService adminUserService = new AdminUserServiceImpl();

    public void login2(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            ResponseDto rtn = adminUserService.login(username, password);
        } catch (AuthenticationFailException e) {
            e.printStackTrace();
        } catch (UpdateFailedException e) {
            e.printStackTrace();
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) {
        try {
            adminUserService.login(req, resp);
        } catch (UpdateFailedException e) {
            e.printStackTrace();
        } catch (AuthenticationFailException e) {
            e.printStackTrace();
        }
    }
}
