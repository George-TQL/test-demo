package com.george.jdbc;

import com.george.domain.Account;
import com.george.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo5 {
    public static void main(String[] args) {
        List<Account> all = new JdbcDemo5().findAll();
        System.out.println(all);
        System.out.println(all.size());
    }

    public List<Account> findAll() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from account";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            Account act = null;
            List list = new ArrayList<Account>();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String password = rs.getString(3);
                act = new Account();
                act.setId(id);
                act.setName(name);
                act.setPassword(password);
                list.add(act);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
