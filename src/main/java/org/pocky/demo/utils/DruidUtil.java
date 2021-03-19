package org.pocky.demo.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DruidUtil {
    private static Properties prop;
    private static DataSource dataSource;

    static {
        // configuration of dataSource
        InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        prop = new Properties();
        try {
            prop.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
