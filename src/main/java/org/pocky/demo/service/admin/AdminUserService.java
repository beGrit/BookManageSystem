package org.pocky.demo.service.admin;


import org.pocky.demo.models.AdminUser;
import org.pocky.demo.dto.JsonResponse;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.exceptions.UpdateFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AdminUserService {
    public AdminUser queryById(Integer id) throws Exception;
    
    public JsonResponse login(String username, String password) throws AuthenticationFailException, UpdateFailedException;

    public void login(HttpServletRequest req, HttpServletResponse resp) throws UpdateFailedException, AuthenticationFailException;
}
