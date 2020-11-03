package com.system.newtikisystem.entity;

import java.util.Date;

public class Comments {
    private int id;
    private String email;
    private int productId;
    private String comment;
    private Date time;

    public Comments() {
    }

    public Comments(int id, String email, int productId, String comment, Date time) {
        this.id = id;
        this.email = email;
        this.productId = productId;
        this.comment = comment;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
