package org.pocky.demo.dao;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.pocky.demo.utils.DruidUtil;

public class BaseDao {
    protected QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
    protected BasicRowProcessor rowProcessor = new BasicRowProcessor(new GenerousBeanProcessor());
}
