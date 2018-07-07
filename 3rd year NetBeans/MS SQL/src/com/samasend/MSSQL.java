package com.samasend;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author SamAsEnd
 */
public class MSSQL {

    public static void main(String[] args) throws Exception {
        String connectionUrl = "jdbc:sqlserver://sam_sql;"
                + "databaseName=AdventureWorks;integratedSecurity=true;"
                + "failoverPartner=serverB";
        Connection con;
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //con = DriverManager.getConnection(connectionUrl);
            //System.out.println("Connected to the principal server.");

            SQLServerDataSource ds = new SQLServerDataSource();

            ds.setUser("PC_SamAsEnd\\SamAsEnd");
            ds.setPassword("");
            ds.setServerName("PC_SAMASEND");
            ds.setPortNumber(1433);
            ds.setDatabaseName("AdventureWorks");
            con = ds.getConnection();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
