package com.system.newtikisystem.entity;

import java.util.Date;

public class Notifications {
    private int id;
    private String email;
    private Date time;
    private String notificationContent;

    public Notifications() {
    }

    public Notifications(int id, String email, Date time, String notificationContent) {
        this.id = id;
        this.email = email;
        this.time = time;
        this.notificationContent = notificationContent;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNotificationContent() {
        return notificationContent;
    }

    public void setNotificationContent(String notificationContent) {
        this.notificationContent = notificationContent;
    }
}
