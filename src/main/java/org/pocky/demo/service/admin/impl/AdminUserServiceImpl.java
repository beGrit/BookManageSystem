package org.pocky.demo.service.admin.impl;


import org.pocky.demo.models.AdminUser;
import org.pocky.demo.dao.AdminDao;
import org.pocky.demo.dao.impl.AdminDaoImpl;
import org.pocky.demo.dto.JsonResponse;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.exceptions.UpdateFailedException;
import org.pocky.demo.service.admin.AdminUserService;
import org.pocky.demo.factory.JsonSerializer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public AdminUser queryById(Integer id) throws Exception {
        AdminUser adminUser = adminDao.query();
        if (adminUser != null) {
            return adminUser;
        } else {
            throw new Exception("admin not found : " + id);
        }
    }

    @Override
    public JsonResponse login(String username, String password) throws AuthenticationFailException, UpdateFailedException {
        JsonResponse rtn = null;
        try {
            AdminUser adminUser;
            adminUser = adminDao.authentication(username, password);
            if (adminUser == null) {
                throw new AuthenticationFailException();
            } else {
                // 修改最后一次的登录时间
                int count = adminDao.updateLoginTime(adminUser, Date.valueOf(LocalDate.now()));
                if (count == 0) {
                    throw new UpdateFailedException();
                }
                rtn = new JsonResponse(200, "登录成功", adminUser);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rtn;
    }

    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) throws UpdateFailedException, AuthenticationFailException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        JsonResponse jsonResponse = login(username, password);
        if (jsonResponse != null) {
            try {
                req.getSession().setAttribute("user", username + password);
                resp.getWriter().write(JsonSerializer.serialize(jsonResponse));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
