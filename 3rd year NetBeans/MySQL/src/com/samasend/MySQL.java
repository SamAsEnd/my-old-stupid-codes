package com.samasend;

import static com.samasend.MySQL.cin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class MySQL {

    static Scanner cin;
    String dbName;
    String username;
    String pass;
    Connection connection;

    public MySQL(String dbName, String username, String pass) {
        this.dbName = dbName;
        this.username = username;
        this.pass = pass;
        connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, username, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            error(ex);
            return;
        }
        error(new Exception("Successfully Connected!!!"));
    }

    public static void main(String[] args) {
        cin = new Scanner(System.in);
        MySQL mySQL;
        mySQL = new MySQL(get(), get(), get());
    }

    public static void error(Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
    }

    static private String get() {
        return JOptionPane.showInputDialog(null, "", "", JOptionPane.QUESTION_MESSAGE);
    }
}
