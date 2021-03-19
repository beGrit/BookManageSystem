package org.pocky.demo.service;


import org.pocky.demo.beans.AdminUser;
import org.pocky.demo.dto.ResponseDto;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.exceptions.UpdateFailedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AdminUserService {
    public AdminUser queryById(Integer id) throws Exception;
    
    public ResponseDto login(String username, String password) throws AuthenticationFailException, UpdateFailedException;

    public void login(HttpServletRequest req, HttpServletResponse resp) throws UpdateFailedException, AuthenticationFailException;
}
