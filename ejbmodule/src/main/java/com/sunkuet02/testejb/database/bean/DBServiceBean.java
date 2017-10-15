package com.sunkuet02.testejb.database.bean;

import com.sunkuet02.testejb.database.entity.Account;
import com.sunkuet02.testejb.database.entity.User;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by sun on 5/18/17.
 */

@Stateless(name = "DBServiceEM")
public class DBServiceBean implements DBService {

    @Resource
    SessionContext sessionContext;

    @PersistenceContext
    private EntityManager entityManager;

    public Object persist(Object object) {
        entityManager.persist(object);
        return object;
    }

    public User addUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public List<User> getAllUser() {
        Query query = entityManager.createQuery("select u from User u");

        return query.getResultList();
    }

    public User getUserByUsername(String username) {
        Query query = entityManager.createQuery("select u from User u where u.username = :username");
        query.setParameter("username", username);

        List<User> users =  (List<User>)query.getResultList();

        return users.size() == 0 ? null: users.get(0);
    }

    public Account addAccount(Account account) {
        entityManager.persist(account);

        return account;
    }

    public List<Account> getAccountByUserId(Long userId) {
        Query query = entityManager.createNativeQuery("select * from ACCOUNT_INFO a where a.ACCOUNT_ID in (select ua.account_id from USER_ACCOUNTS ua where ua.user_id=?1)", Account.class);
        query.setParameter("1", userId);
        return query.getResultList();
    }
}
