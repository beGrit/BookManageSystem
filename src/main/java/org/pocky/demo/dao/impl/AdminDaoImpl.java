package org.pocky.demo.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.pocky.demo.models.AdminUser;
import org.pocky.demo.dao.AdminDao;
import org.pocky.demo.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Date;

@Repository
public class AdminDaoImpl extends BaseDao implements AdminDao {

    @Override
    public AdminUser query() throws SQLException {
        // f1.BeanHandler automatic mapping db_column -> property
        String sql = "select * from AdminUser";
        AdminUser adminUser = queryRunner.query(sql, new BeanHandler<>(AdminUser.class, rowProcessor));
        return adminUser;
        // f2.raw sql + user-defined ResultSetHandler
    }

    @Override
    public AdminUser authentication(String username, String password) throws SQLException {
        String sqlStatement = "select * from AdminUser where username = ? and password = ? and is_deleted = 0";
        AdminUser adminUser = queryRunner.query(sqlStatement, new BeanHandler<>(AdminUser.class, rowProcessor), username, password);
        return adminUser;
    }

    @Override
    public int updateLoginTime(AdminUser user, Date time) throws SQLException {
        int rtn;
        String sql = "update AdminUser set last_login_time= ? where id = ?";
        Integer id = user.getId();
        rtn = queryRunner.update(sql, time, id);
        return rtn;
    }

    public int[] batch(Object[][] params) throws SQLException {
        String sql = "delete from AdminUser where id = ?";
        int[] rtns = queryRunner.batch(sql, params);
        return rtns;
    }
}
