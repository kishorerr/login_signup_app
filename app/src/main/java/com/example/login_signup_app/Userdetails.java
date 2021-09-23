package com.example.login_signup_app;

import androidx.annotation.NonNull;

public class Userdetails {
    private String userid,username,location;

    @NonNull
    @Override
    public String toString() {
        return "Userdetails{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public Userdetails() {
    }

    public Userdetails(String userid, String username, String location) {
        this.userid = userid;
        this.username = username;
        this.location = location;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

