package com.sunkuet02.testejb.webservice.bean;

import com.sunkuet02.testejb.webservice.request.AddUserRequest;
import com.sunkuet02.testejb.webservice.request.LoginRequest;
import com.sunkuet02.testejb.webservice.response.AddUserServiceResponse;
import com.sunkuet02.testejb.webservice.response.LoginServiceResponse;

import javax.ejb.Remote;

/**
 * Created by sun on 5/21/17.
 */
@Remote
public interface BankingWService {

    LoginServiceResponse login(LoginRequest request);

    AddUserServiceResponse addUser(AddUserRequest request);
}
