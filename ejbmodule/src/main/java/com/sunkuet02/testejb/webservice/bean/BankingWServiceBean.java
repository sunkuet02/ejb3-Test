package com.sunkuet02.testejb.webservice.bean;

import com.sunkuet02.testejb.business.bean.BankingService;
import com.sunkuet02.testejb.business.entity.User;
import com.sunkuet02.testejb.webservice.request.AddUserRequest;
import com.sunkuet02.testejb.webservice.request.LoginRequest;
import com.sunkuet02.testejb.webservice.response.AddUserServiceResponse;
import com.sunkuet02.testejb.webservice.response.LoginServiceResponse;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by sun on 5/21/17.
 */
@Stateless(name = "BankingWS")
@WebService(name = "BankingWS", serviceName = "BankingWS", portName = "BankingServicePort")
public class BankingWServiceBean implements BankingWService {

    @Resource
    SessionContext sessionContext;

    @EJB
    private BankingService bankingService;

    @WebMethod
    public String hello() {
        return "Said : hello";
    }

    @WebMethod
    public LoginServiceResponse login(@WebParam(name = "request") LoginRequest request) {
        boolean isLoggedIn = bankingService.login(request.getUsername(), request.getPassword());
        return new LoginServiceResponse(isLoggedIn);
    }

    @WebMethod
    public AddUserServiceResponse addUser(@WebParam(name = "request") AddUserRequest request) {
        User user = new User(request.getName(), request.getUsername(), request.getPassword());
        try {
            bankingService.addUser(user);
        } catch (Exception e) {
            return new AddUserServiceResponse("Fail");
        }
        return new AddUserServiceResponse("success");
    }
}
