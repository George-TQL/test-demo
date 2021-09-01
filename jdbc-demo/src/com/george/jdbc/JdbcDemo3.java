package com.george.jdbc;

import java.sql.*;

public class JdbcDemo3 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet ret = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            stmt = conn.createStatement();
            String sql = "select * from student1";
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                int anInt = ret.getInt(1);
                String name = ret.getString("name");
                int age = ret.getInt("age");
                System.out.println(anInt + "----" + name + "----" + age);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (ret != null) {
                try {
                    ret.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn !=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
