package com.sunkuet02.testejb.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sun on 5/8/17.
 */

@Entity
@Table(name = "USER_INFO")
public class User implements Serializable{

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ASSIGN_ID_HUSER_INFO")
    @SequenceGenerator(name = "ASSIGN_ID_HUSER_INFO", sequenceName = "SEQ_USER_INFO", allocationSize = 1)
    private Long id;

    String name;

    String username;

    String password;

    @JoinTable(name = "USER_ACCOUNTS",joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ACCOUNT_ID")})
    @OneToMany(cascade = CascadeType.ALL)
    private List<Account> account;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        String userString = "ID: " + id + ", NAME: " + name + ", Username: " + username +
                ", Password: " + password+ ", AccountIds : " ;
        for(Account account : this.account) {
            userString += account.getId() + ", ";
        }
        return userString;
    }
}
