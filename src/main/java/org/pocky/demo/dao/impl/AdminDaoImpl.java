package org.pocky.demo.dao.impl;

import lombok.Data;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.pocky.demo.beans.AdminUser;
import org.pocky.demo.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public AdminUser query() {
        try {
            return queryRunner.query("select * from AdminUser", new ResultSetHandler<AdminUser>() {
                @Override
                public AdminUser handle(ResultSet resultSet) throws SQLException {
                    AdminUser adminUser = new AdminUser();
                    while (resultSet.next()) {
                        adminUser.setId(resultSet.getInt("id"));
                        adminUser.setUsername(resultSet.getString("username"));
                        adminUser.setPassword(resultSet.getString("password"));
                    }
                    return adminUser;
                }
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public AdminUser authentication(String username, String password) {
        try {
            String sqlStatement;
            sqlStatement = String.format("select * from AdminUser where username = ? and password = ?", username, password);
            queryRunner.query(sqlStatement, new ResultSetHandler<AdminUser>() {
                @Override
                public AdminUser handle(ResultSet resultSet) throws SQLException {
                    AdminUser adminUser = null;
                    while (resultSet.next()) {
                        Integer id = resultSet.getInt("id");
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        Date lastLoginTime = resultSet.getDate("last_login_time");
                        adminUser = new AdminUser();
                        adminUser.setUsername(username);
                        adminUser.setPassword(password);
                        adminUser.setId(id);
                        adminUser.setLastLoginTime(lastLoginTime);
                    }
                    return adminUser;
                }
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateLoginTime(AdminUser user, Date time) {
        Integer id = user.getId();
        String sql = "update AdminUser set last_login_time=? where id=?";
        String.format(sql, time, id);
        int rtn = 0;
        try {
            rtn = queryRunner.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rtn;
    }
}
