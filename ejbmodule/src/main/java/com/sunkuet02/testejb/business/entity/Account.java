package com.sunkuet02.testejb.business.entity;

/**
 * Created by sun on 5/21/17.
 */
public class Account {
    private Long id;

    private String accountName;

    private String accountNo;

    public Account() {
    }

    public Account(Long id, String accountName, String accountNo) {
        this.id = id;
        this.accountName = accountName;
        this.accountNo = accountNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
