package com.system.newtikisystem.databases.models;

import java.io.Serializable;
import java.util.Date;

public class Favorites implements Serializable {
    private String email;
    private int productid;
    private Date time;

    public Favorites(String email, int productid, Date time) {
        this.email = email;
        this.productid = productid;
        this.time = time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Favorites{" +
                "email='" + email + '\'' +
                ", productid=" + productid +
                ", time=" + time +
                '}';
    }
}
