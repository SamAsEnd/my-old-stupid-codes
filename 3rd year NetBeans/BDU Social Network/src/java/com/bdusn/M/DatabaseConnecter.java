package com.bdusn.M;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnecter implements DatabaseConfiguration {

    private Connection connection;

    public DatabaseConnecter() throws DataBaseConnectionException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=" + DATABASE_NAME + ";", DATABASE_USER, DATABASE_PASSWORD);
        } catch (Exception e) {
            throw new DataBaseConnectionException();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
