package com.george.jdbc;

import com.george.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JdbcDemo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        Boolean login = new JdbcDemo4().login2(username, password);
        if (login) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    public Boolean login(String username, String password) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from account where name = '"+username+"' and password = '"+password+"' ";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return false;

    }

    public Boolean login2(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from account where name = ? and password = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstmt, conn);
        }

        return false;
    }
}
