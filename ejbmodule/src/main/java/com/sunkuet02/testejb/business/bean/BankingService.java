package com.sunkuet02.testejb.business.bean;

import com.sunkuet02.testejb.business.entity.User;

import javax.ejb.Remote;

/**
 * Created by sun on 5/21/17.
 */
@Remote
public interface BankingService {
    boolean login(String userName, String password);

    User addUser(User user);
}
