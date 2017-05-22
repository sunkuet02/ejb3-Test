package com.sunkuet02.testejb.testutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by sun on 5/8/17.
 */
public class Utils {
    public static Properties getDbProperties() {
        Properties p = new Properties();
//        properties.put("javax.persistence.jdbc.driver", "org.hsqldb.jdbcDriver");
//        properties.put("javax.persistence.jdbc.user","sa");
//        properties.put("javax.persistence.jdbc.password" ,"");
//        properties.put("javax.persistence.jdbc.url" ,"jdbc:hsqldb:mem:testdb");
        p.put("BankingDS", "new://Resource?type=DataSource");
        p.put("BankingDS.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("BankingDS.JdbcUrl", "jdbc:hsqldb:mem:bankingdb");
        p.put("eclipselink.ddl-generation", "drop-and-create-tables");
        return p;
    }
}
