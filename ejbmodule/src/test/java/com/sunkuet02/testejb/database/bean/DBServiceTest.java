package com.sunkuet02.testejb.database.bean;

import com.sunkuet02.testejb.database.entity.Account;
import com.sunkuet02.testejb.database.entity.User;
import com.sunkuet02.testejb.testutils.Utils;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sun on 5/18/17.
 */
public class DBServiceTest {
    private final static Logger logger = Logger.getLogger(DBServiceTest.class);

    private EJBContainer container;
    private DBService dbService;

    @Before
    public void setUp() throws NamingException {
        Properties containerProperties = Utils.getDbProperties();
        containerProperties.put(EJBContainer.MODULES, new File("target/classes"));
        container = EJBContainer.createEJBContainer(containerProperties);
        dbService = (DBService) container.getContext().lookup("java:global/ejbmodule/DBServiceEM!com.sunkuet02.testejb.database.bean.DBService");
    }

    @After
    public void tearDown() {
        if(container != null) {
            container.close();
        }
    }

    @Test
    public void persist() throws Exception {
        User user = new User("Alauddin", "Alauddin", "Alauddin");
        Account account = new Account("Dbbl", "123.123.123");

        List<Account> accountList = new ArrayList<Account>();
        accountList.add(account);
        user.setAccount(accountList);

        user = (User)dbService.persist(user);

        assertTrue(user.getId() > 0);
        assertTrue(user.getAccount().get(0).getId() > 0);

        assertEquals("Dbbl", dbService.getAccountByUserId(user.getId()).get(0).getAccountName());
    }

}