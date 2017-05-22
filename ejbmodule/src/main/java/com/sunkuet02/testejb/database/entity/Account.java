package com.sunkuet02.testejb.database.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sun on 5/17/17.
 */
@Entity
public class Account implements Serializable {

    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSIGN_ID_HACCOUNT_INFO")
    @SequenceGenerator(name = "ASSIGN_ID_HACCOUNT_INFO", sequenceName = "SEQ_ACCOUNT_INFO", allocationSize = 1)
    private Long id;

    private String accountName;

    private String accountNo;

    public Account() {
    }

    public Account(String accountName, String accountNo) {
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
