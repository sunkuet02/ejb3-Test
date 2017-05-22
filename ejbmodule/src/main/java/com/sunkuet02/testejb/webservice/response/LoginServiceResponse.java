package com.sunkuet02.testejb.webservice.response;

import java.io.Serializable;

/**
 * Created by sun on 5/21/17.
 */
public class LoginServiceResponse implements Serializable {
    private boolean loggedIn;

    public LoginServiceResponse() {
    }

    public LoginServiceResponse(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
