package com.system.newtikisystem.dao;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.entity.FavoriteProduct;
import com.system.newtikisystem.entity.Favorites;
import com.system.newtikisystem.entity.Notifications;
import com.system.newtikisystem.entity.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductTDAO extends DatabaseManager {
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<FavoriteProduct> getListProductFavorite(String email) {
        ArrayList<FavoriteProduct> list = new ArrayList<>();
        try {
            String query = "SELECT   top 1 with ties  p.id,pf.email,p.name,pf.[time],p.price,pp.imageurl\n" +
                    "FROM products p INNER JOIN\n" +
                    "favorites pf ON p.id = pf.productid INNER JOIN\n" +
                    "product_pictures pp ON pf.productid = p.id\n" +
                    "where email=?\n" +
                    "order by ROW_NUMBER() over (partition by p.id order by p.id)";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setString(1,email);
            rs = ps.executeQuery();
            while (rs.next()) {
                FavoriteProduct fp = new FavoriteProduct();
                fp.setId(rs.getInt(1));
                fp.setEmail(rs.getString(2));
                fp.setName(rs.getString(3));
                fp.setTime(rs.getDate(4));
                fp.setPrice(rs.getInt(5));
                fp.setImageURL(rs.getString(6));
                list.add(fp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
