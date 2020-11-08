package com.system.newtikisystem.entity;

import java.util.Date;

public class Categories {
    private int id;
    private String name;
    private String description;
    private boolean status;
    private Date createDate;

    public Categories() {
    }

    public Categories(int id, String name, String description, boolean status, Date createDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
