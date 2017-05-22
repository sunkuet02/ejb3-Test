package com.sunkuet02.testejb.webservice.request;

import java.io.Serializable;

/**
 * Created by sun on 5/21/17.
 */
public class LoginRequest implements Serializable {
    private String username;

    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
