package com.sunkuet02.testejb.testutils;

import javax.naming.Context;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by sun on 5/8/17.
 */
public class Utils {
    public static Properties getDbProperties() {
        Properties p = new Properties();

        // Below lines are for testing in real database
        /*
        p.put(Context.INITIAL_CONTEXT_FACTORY,"org.apache.openejb.client.LocalInitialContextFactory");
        p.put("BankingDS", "new://Resource?type=DataSource");
        p.put("BankingDS.JdbcDriver", "org.postgresql.Driver");
        p.put("BankingDS.JdbcUrl", "jdbc:postgresql://localhost:5432/bank");
        p.put("BankingDS.username", "postgres");
        p.put("BankingDS.password", "tigerit");
        */

        //Below lines are for testing in memory hsql database
        p.put("BankingDS", "new://Resource?type=DataSource");
        p.put("BankingDS.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("BankingDS.JdbcUrl", "jdbc:hsqldb:mem:bankingdb");
        p.put("eclipselink.ddl-generation", "drop-and-create-tables");

        return p;
    }
}
