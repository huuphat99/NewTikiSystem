package com.system.newtikisystem.databases.models;

import java.io.Serializable;

public class Productrating implements Serializable {
    private int productid;
    private String email;
    private String ratingContext;
    private float stars;

    public Productrating(int productid, String email, String ratingContext, float stars) {
        this.productid = productid;
        this.email = email;
        this.ratingContext = ratingContext;
        this.stars = stars;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRatingContext() {
        return ratingContext;
    }

    public void setRatingContext(String ratingContext) {
        this.ratingContext = ratingContext;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }
}
