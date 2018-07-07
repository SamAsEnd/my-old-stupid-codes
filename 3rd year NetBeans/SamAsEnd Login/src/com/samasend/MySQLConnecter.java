package com.samasend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SamAsEnd
 */
public class MySQLConnecter {

    private Connection connect(String dbName, String usename, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, usename, password);
    }

    private Connection connect(String dbName) throws SQLException, ClassNotFoundException {
        return connect(dbName, "root", "");
    }
    private String dbName;
    private Connection connection;

    public MySQLConnecter(String dbName) throws SQLException, ClassNotFoundException {
        this.dbName = dbName;
        connection = connect(dbName);
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException, Exception {
        if (connection == null) {
            connection = connect(dbName);
        }
        if (connection == null) {
            throw new Exception("can't connect!");
        }
        return connection;
    }
}
