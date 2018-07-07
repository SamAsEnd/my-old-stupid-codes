package com.css;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnect {

    private String userName;
    private String password;
    private String databaseName;
    private Connection connection;

    public DBConnect(String userName, String password, String databaseName) {
        this.userName = userName;
        this.password = password;
        this.databaseName = databaseName;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, userName, password);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }
    }

    public DBConnect() {
        this("root", "", "css");
    }
    
    public Connection getConnection() {
        return connection;
    }
    
}
