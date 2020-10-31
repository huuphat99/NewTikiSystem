package com.system.newtikisystem.entity;

public class Productrating {
    private int productid;
    private String email;
    private String ratingContent;
    private float stats;

    public Productrating() {
        this.productid = productid;
        this.email = email;
        this.ratingContent = ratingContent;
        this.stats = stats;
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

    public String getRatingContent() {
        return ratingContent;
    }

    public void setRatingContent(String ratingContent) {
        this.ratingContent = ratingContent;
    }

    public float getStats() {
        return stats;
    }

    public void setStats(float stats) {
        this.stats = stats;
    }
}
