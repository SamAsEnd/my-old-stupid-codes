package com.samasend.mysql;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * This class is used to encapsulate th db connection to MySQL
 *
 * @author SamAsEnd
 *
 */
public class MySQLConnection {

    private String dataBaseName;
    private String username;
    private String password;
    private Connection connection;
    private Statement statement;

    /**
     * @param dataBaseName
     * @param username
     * @param password
     */
    public MySQLConnection(String dataBaseName, String username, String password) {
        this.dataBaseName = dataBaseName;
        this.username = username;
        this.password = password;
        connectToDb();
    }

    /**
     * The default <b>password</b> will be
     * <code>null</code><br/>
     *
     * @param dataBaseName
     * @param username
     */
    public MySQLConnection(String dataBaseName, String username) {
        this(dataBaseName, username, null);
    }

    /**
     * The default <b>username</b> will be
     * <code>root</code><br/>
     * The default <b>password</b> will be
     * <code>null</code><br/>
     *
     * @param dataBaseName
     */
    public MySQLConnection(String dataBaseName) {
        this(dataBaseName, "root", null);
    }

    private void connectToDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dataBaseName, username, password);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            String err = ex.getClass().getName()+ ": " + ex.toString();
            System.err.println(err);
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int executeUpdate(String q) throws SQLException {
        return statement.executeUpdate(q);
    }
    
    public ResultSet executeQuery(String q) throws SQLException {
        return statement.executeQuery(q);
    }
    
}
