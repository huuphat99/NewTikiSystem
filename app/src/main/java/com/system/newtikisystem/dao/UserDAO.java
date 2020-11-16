package com.system.newtikisystem.dao;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DatabaseManager {


    public User checkLogin(String username, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            try {
                String query = "SELECT [email]\n" +
                        "      ,[pass_word]\n" +
                        "      ,[name]\n" +
                        "      ,[phone]\n" +
                        "      ,[dob]\n" +
                        "  FROM [PRM391].[dbo].[users] where email = ? and pass_word = ?;";
                connection = connect();
                ps = connection.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setEmail(rs.getString(1));
                    user.setPass_word(rs.getString(2));
                    user.setName(rs.getString(3));
                    user.setPhone(rs.getString(4));
                    user.setDob(rs.getDate(5));
                    return user;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkUserForget(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT[email]\n" +
                    "      ,[pass_word]\n" +
                    "      ,[name]\n" +
                    "      ,[phone]\n" +
                    "      ,[dob]\n" +
                    "  FROM [PRM391].[dbo].[users] where email = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString(1));
                user.setPass_word(rs.getString(2));
                user.setName(rs.getString(3));
                user.setPhone(rs.getString(4));
                user.setDob(rs.getDate(5));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int updatePassword(String username, String password) {
        PreparedStatement ps = null;

        try {
            String query = "UPDATE [PRM391].[dbo].[users] SET pass_word = ? WHERE email = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User getInfo(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT name,email from [users] where email=?";
            connection = connect();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setName(rs.getString(1));
                user.setEmail(rs.getString(2));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
