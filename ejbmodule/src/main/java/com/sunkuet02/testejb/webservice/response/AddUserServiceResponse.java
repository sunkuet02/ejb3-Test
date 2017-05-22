package com.sunkuet02.testejb.webservice.response;

import java.io.Serializable;

/**
 * Created by sun on 5/21/17.
 */
public class AddUserServiceResponse implements Serializable {
    private String message;

    public AddUserServiceResponse() {
    }

    public AddUserServiceResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
