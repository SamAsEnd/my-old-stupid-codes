package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnecter {

    private Connection connection;

    public DatabaseConnecter() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Hotel_Managment", "sa", "sam");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // test SQL connection
    public static void main(String[] args) {
        DatabaseConnecter dc = new DatabaseConnecter();
        System.out.println(dc.getConnection());
    }

}
