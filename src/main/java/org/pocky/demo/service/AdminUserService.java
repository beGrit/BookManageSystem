package org.pocky.demo.service;


import org.pocky.demo.beans.AdminUser;
import org.pocky.demo.exceptions.AuthenticationFailException;

public interface AdminUserService {
    public AdminUser queryById(Integer id) throws Exception;
    
    public AdminUser login(String username, String password) throws AuthenticationFailException;
}
