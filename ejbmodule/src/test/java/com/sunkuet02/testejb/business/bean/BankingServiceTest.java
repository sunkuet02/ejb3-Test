package com.sunkuet02.testejb.business.bean;

import com.sunkuet02.testejb.business.entity.User;
import com.sunkuet02.testejb.testutils.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.io.File;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sun on 5/21/17.
 */
public class BankingServiceTest {

    private final static Logger logger = Logger.getLogger(BankingServiceTest.class);

    private EJBContainer container;
    private BankingService bankingService;

    @Before
    public void setUp() throws NamingException {
        Properties containerProperties = Utils.getDbProperties();
        containerProperties.put(EJBContainer.MODULES, new File("target/classes"));
        container = EJBContainer.createEJBContainer(containerProperties);
        bankingService = (BankingService) container.getContext().lookup("java:global/ejbmodule/BankingServiceB!com.sunkuet02.testejb.business.bean.BankingService");
    }

    @After
    public void tearDown() {
        if(container != null) {
            container.close();
        }
    }

    @Test
    public void login() throws Exception {
        User user = new User("Shibli", "shibli", "shibli");

        user = bankingService.addUser(user);

        assertTrue(user.getId() > 0);

        assertEquals(true, bankingService.login("shibli", "shibli"));
        assertEquals(false, bankingService.login("shibli", "shibli12"));
    }

}