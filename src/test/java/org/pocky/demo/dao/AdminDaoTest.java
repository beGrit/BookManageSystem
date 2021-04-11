package org.pocky.demo.dao;

import org.junit.jupiter.api.Test;
import org.pocky.demo.models.AdminUser;
import org.pocky.demo.dao.impl.AdminDaoImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

class AdminDaoTest {

    AdminDao adminDao = new AdminDaoImpl();

    @Test
    void query() {
        try {
            AdminUser adminUser = adminDao.query();
            System.out.println(adminUser);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Test
    void authentication() {
        try {
            AdminUser adminUser = adminDao.authentication("LSF", "LSFlsf123");
            System.out.println(adminUser);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

//    @Test
    void updateLoginTime() {
        AdminUser adminUser = new AdminUser();
        adminUser.setId(1);
        try {
            adminDao.updateLoginTime(adminUser, Date.valueOf(LocalDate.now()));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}