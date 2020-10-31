package com.system.newtikisystem.dao;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.entity.Productrating;
import com.system.newtikisystem.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends DatabaseManager {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public User getData(String username, String password) throws Exception {
        try {
            Statement statement = null;
            try {
                String query = "SELECT TOP (1000) [id]\n" +
                        "      ,[username]\n" +
                        "      ,[password]\n" +
                        "  FROM [testdb].[dbo].[user] where username = ? and password = ?";
                connection = connect();
                ps = connection.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                while (rs.next()){
                    User product = new User();
                    product.setId(rs.getInt(1));
                    product.setUsername(rs.getString(2));
                    product.setPassword(rs.getString(3));
                    return product;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
