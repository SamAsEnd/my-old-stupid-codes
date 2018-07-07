package com.bdusn.M;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBaseConnecter implements DataBaseSetting {

    public static Connection connection;

    static {
        try {
            // the leatest version of MS SQL JDBC 4.0 connecter
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=" + DATABASE, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * <b>Test Database Connection</b><br/>
     *
     * @param args
     */
    public static void main(String[] args) {
        if (connection == null) {
            System.err.println("Error On CONNECTION");
        } else {
            System.out.println("Successfully Connected");
        }
    }

    private DataBaseConnecter() {
    }
}
