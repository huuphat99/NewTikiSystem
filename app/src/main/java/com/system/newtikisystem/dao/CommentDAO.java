package com.system.newtikisystem.dao;

import com.system.newtikisystem.databases.DatabaseManager;
import com.system.newtikisystem.entity.Comment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends DatabaseManager {

    PreparedStatement statement;
    ResultSet rs;

    public List<Comment> getCommentsByProductId(int productId) {
        List<Comment> comments = new ArrayList<>();

        try {
            String sql = "select * from comments where productid = ? order by commenttime DESC";
            connection = connect();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, productId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setQuestion(rs.getString("comment"));
                comment.setAnswer(rs.getString("answer"));
                comments.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return comments;
    }

    public void insertComment(String email,int productid,String comment) {
        try {
            String sql = "insert into comments (email,productid,comment,commenttime)\n" +
                    "values (?,?,?,GETDATE())";
            connection = connect();
            statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            statement.setInt(2,productid);
            statement.setString(3,comment);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
