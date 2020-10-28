package com.system.newtikisystem.databases.models;

import java.io.Serializable;

public class Advertisements implements Serializable {
    private int id;
    private int productid;
    private String mediaurl;
    private boolean status;

    public Advertisements() {
    }

    public Advertisements(int id, int productid, String mediaurl, boolean status) {
        this.id = id;
        this.productid = productid;
        this.mediaurl = mediaurl;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getMediaurl() {
        return mediaurl;
    }

    public void setMediaurl(String mediaurl) {
        this.mediaurl = mediaurl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Advertisements{" +
                "id=" + id +
                ", productid=" + productid +
                ", mediaurl='" + mediaurl + '\'' +
                ", status=" + status +
                '}';
    }
}
