package com.sunkuet02.testejb.business.entity;

import java.io.Serializable;

/**
 * Created by sun on 5/21/17.
 */
public class User implements Serializable{

    private Long id;

    private String name;

    private String username;

    private String password;

    public User() {
    }

    public User(Long id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        String userString = "ID: " + id + ", NAME: " + name + ", Username: " + username +
                ", Password: " + password;
        return userString;
    }
}
