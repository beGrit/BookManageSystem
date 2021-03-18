package org.pocky.demo.service.impl;


import org.pocky.demo.beans.AdminUser;
import org.pocky.demo.dao.AdminDao;
import org.pocky.demo.exceptions.AuthenticationFailException;
import org.pocky.demo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminDao adminDao;

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
    public AdminUser login(String username, String password) throws AuthenticationFailException {
        AdminUser adminUser = adminDao.authentication(username, password);
        if (adminUser == null) {
            throw new AuthenticationFailException();
        } else {
            // 修改最后一次的登录时间
//            adminDao.updateLoginTime(adminUser, );
            return adminUser;
        }
    }


}
