package com.system.newtikisystem.entity;

import java.util.Date;

public class User {
    private String  email;
    private String pass_word;
    private String name;
    private String phone;
    private Date dob;

    public User() {
    }

    public User(String email, String pass_word, String name, String phone, Date dob) {
        this.email = email;
        this.pass_word = pass_word;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
