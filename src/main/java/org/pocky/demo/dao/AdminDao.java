package org.pocky.demo.dao;


import org.pocky.demo.beans.AdminUser;

import java.sql.SQLException;
import java.util.Date;

public interface AdminDao {
    public AdminUser query() throws SQLException;

    public AdminUser authentication(String username, String password) throws SQLException;

    public int updateLoginTime(AdminUser adminUser, Date time) throws SQLException;
}
