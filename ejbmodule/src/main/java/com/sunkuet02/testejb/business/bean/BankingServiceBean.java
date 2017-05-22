package com.sunkuet02.testejb.business.bean;

import com.sunkuet02.testejb.business.entity.User;
import com.sunkuet02.testejb.database.bean.DBService;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
/**
 * Created by sun on 5/21/17.
 */

@Stateless(name = "BankingServiceB")
public class BankingServiceBean implements BankingService {

    private final static Logger logger = Logger.getLogger(BankingServiceBean.class);

    @Resource
    private SessionContext sessionContext;

    @EJB
    private DBService dbService;

    public boolean login(String userName, String password) {
        com.sunkuet02.testejb.database.entity.User userEO = dbService.getUserByUsername(userName);
        if(userEO == null ) return false;

        User user = new User(userEO.getName(), userEO.getUsername(), userEO.getPassword());

        if (password.equals(user.getPassword())) return true;
        return false;
    }

    public User addUser(User user) {
        com.sunkuet02.testejb.database.entity.User userEO = new com.sunkuet02.testejb.database.entity.User();
        userEO.setName(user.getName());
        userEO.setUsername(user.getUsername());
        userEO.setPassword(user.getPassword());

        userEO  = dbService.addUser(userEO);
        return new User(userEO.getId(), userEO.getName(), userEO.getUsername(), userEO.getPassword());
    }


}
