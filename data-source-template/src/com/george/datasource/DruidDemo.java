package com.george.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("iiiiii");
        Properties pro = new Properties();
        pro.load(DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        System.out.println("tttttt");
        Connection conn = ds.getConnection();
        System.out.println(conn);
        System.out.println("dddd");
        System.out.println("tttt");
        //添加注释
    }
}
