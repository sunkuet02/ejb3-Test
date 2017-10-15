package com.sunkuet02.testejb.webservice.bean;

import com.sunkuet02.testejb.testutils.Utils;
import com.sunkuet02.testejb.webservice.request.AddUserRequest;
import com.sunkuet02.testejb.webservice.request.LoginRequest;
import com.sunkuet02.testejb.webservice.response.AddUserServiceResponse;
import com.sunkuet02.testejb.webservice.response.LoginServiceResponse;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.io.File;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by sun on 5/21/17.
 */
public class BankingWServiceTest {

    private final static Logger logger = Logger.getLogger(BankingWServiceTest.class);

    private EJBContainer container;
    private BankingWService bankingWService;

    @Before
    public void setUp() throws NamingException {
        Properties containerProperties = Utils.getDbProperties();
        containerProperties.put(EJBContainer.MODULES, new File("target/classes"));
        container = EJBContainer.createEJBContainer(containerProperties);
        bankingWService = (BankingWService) container.getContext().lookup("java:global/ejbmodule/BankingWS!com.sunkuet02.testejb.webservice.bean.BankingWService");
    }

    @After
    public void tearDown() {
        if(container != null) {
            container.close();
        }
    }

    @Test
    public void login() throws Exception {
        AddUserRequest addUserRequest = new AddUserRequest("sun", "sunkuet02", "sunkuet02");
        AddUserServiceResponse addUserServiceResponse = bankingWService.addUser(addUserRequest);

        assertTrue("success".equals(addUserServiceResponse.getMessage()) );

        LoginRequest loginRequest = new LoginRequest("sunkuet02", "sunkuet02");

        LoginServiceResponse loginServiceResponse = bankingWService.login(loginRequest);
        assertEquals(true, loginServiceResponse.isLoggedIn());

        loginRequest = new LoginRequest("sunkuet02", "sunkuet");
        loginServiceResponse = bankingWService.login(loginRequest);
        assertEquals(false, loginServiceResponse.isLoggedIn());

    }

}