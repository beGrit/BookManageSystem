package org.pocky.demo.dao;


import org.pocky.demo.beans.AdminUser;

import java.util.Date;

public interface AdminDao {
    public AdminUser query();

    public AdminUser authentication(String username, String password);

    public int updateLoginTime(AdminUser adminUser, Date time);
}
