package com.system.newtikisystem.dao;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.entity.CartItem;
import com.system.newtikisystem.entity.Orders;
import com.system.newtikisystem.entity.PaymentMethods;
import com.system.newtikisystem.entity.Productrating;
import com.system.newtikisystem.entity.Products;

import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DatabaseManager {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Orders> getOrdersByEmail(String email) {
        ArrayList<Orders> orders = new ArrayList<>();
        try {
            String query = "select * from orders where email = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt(1));
                order.setEmail(rs.getString(2));
                order.setOrderTime(rs.getDate(3));
                order.setShipTime(rs.getDate(4));
                order.setDestination(rs.getString(5));
                order.setTotalPrice(rs.getInt(6));
                order.setStatus(rs.getInt(7) == 1 ? true : false);
                order.setPaymentmethod(rs.getInt(8));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public void rateProduct(Productrating productrating) {
        try {
            String query = "insert into productrating values (?,?,?,?)";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setInt(1, productrating.getProductid());
            ps.setString(2, productrating.getEmail());
            ps.setString(3, productrating.getRatingContent());
            ps.setFloat(4, productrating.getStars());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Orders getOrderById(int id) {
        ArrayList<Orders> orders = new ArrayList<>();
        try {
            String query = "select * from orders where id = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders order = new Orders();
                order.setId(rs.getInt(1));
                order.setEmail(rs.getString(2));
                order.setOrderTime(rs.getDate(3));
                order.setShipTime(rs.getDate(4));
                order.setDestination(rs.getString(5));
                order.setTotalPrice(rs.getInt(6));
                order.setStatus(rs.getInt(7) == 1 ? true : false);
                order.setPaymentmethod(rs.getInt(8));
                orders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders.get(0);
    }

    public ArrayList<Products> getProductsByOrder(int orderId) {
        ArrayList<Products> products = new ArrayList<>();
        try {
            String query = "select p.* from \n" +
                    "  products p \n" +
                    "  inner join order_product od on p.id = od.productid\n" +
                    "  inner join orders o on od.orderid = o.id\n" +
                    "  where o.id = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Products product = new Products();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
                product.setStatus(rs.getInt(4) == 1 ? true : false);
                product.setSale(rs.getFloat(5));
                product.setSalepriority(rs.getInt(6));
                product.setPrice(rs.getInt(7));
                product.setClickTimes(rs.getInt(8));
                product.setCreateTime(rs.getDate(9));
                product.setProducer(rs.getString(10));
                product.setOrigin(rs.getString(11));
                product.setGuarantee(rs.getString(12));
                product.setSpecifications(rs.getString(13));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public String getNameOfListProducts(@NotNull ArrayList<Products> products) {
        ArrayList<String> names = new ArrayList<>();
        for (Products product : products) {
            names.add(product.getName());
        }
        String nameOfList = String.join(" + ", names);
        return nameOfList;
    }

    public PaymentMethods getPaymentMethodById(int id) {
        ArrayList<PaymentMethods> paymentMethods = new ArrayList<>();
        try {
            String query = "select * from paymentmethods where id = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                PaymentMethods pm = new PaymentMethods();
                pm.setId(rs.getInt(1));
                pm.setName(rs.getString(2));
                paymentMethods.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentMethods.get(0);
    }

    public ArrayList<CartItem> getCartItemsByOrder(int orderId) {
        ArrayList<CartItem> cartItems = new ArrayList<>();
        try {
            String query = "select top 1 with ties p.id, p.name,pp.imageurl, od.quantity, p.price, p.sale from \n" +
                    "  orders o \n" +
                    "  inner join order_product od on o.id = od.orderid\n" +
                    "  inner join products p on od.productid = p.id\n" +
                    "  inner join product_pictures pp on p.id = pp.productid\n" +
                    "  where o.id = ?\n" +
                    "  order by ROW_NUMBER() over (partition by p.id order by p.id)";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartItem item = new CartItem();
                item.setId(rs.getInt(1));
                item.setName(rs.getString(2));
                item.setUrl(rs.getString(3));
                item.setQuantity(rs.getInt(4));
                item.setPrice(rs.getInt(5));
                item.setSale(rs.getInt(6));
                cartItems.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public boolean isRatedPosition(String email, int productId) {
        String checkEmail = null;
        try {
            String query = "select * from productrating where email = ? and productid = ?";
            connection = connect();
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setInt(2, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                checkEmail = rs.getString(2);
            }
            if (checkEmail != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
