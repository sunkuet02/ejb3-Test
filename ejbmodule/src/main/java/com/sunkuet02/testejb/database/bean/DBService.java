package com.sunkuet02.testejb.database.bean;

import com.sunkuet02.testejb.database.entity.Account;
import com.sunkuet02.testejb.database.entity.User;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by sun on 5/18/17.
 */

@Remote
public interface DBService {
    Object persist(Object object);

    User addUser(User user);

    List<User> getAllUser();

    User getUserByUsername(String username);

    Account addAccount(Account account);

    List<Account> getAccountByUserId(Long userId);
}
