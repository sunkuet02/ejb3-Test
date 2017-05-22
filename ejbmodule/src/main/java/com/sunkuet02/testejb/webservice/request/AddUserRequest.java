package com.sunkuet02.testejb.webservice.request;

import com.sunkuet02.testejb.business.entity.User;

import java.io.Serializable;

/**
 * Created by sun on 5/21/17.
 */
public class AddUserRequest extends User implements Serializable{
    public AddUserRequest() {
        super();
    }

    public AddUserRequest(String name, String username, String password) {
        super(name, username, password);
    }
}
