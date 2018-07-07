package com.samasendl;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sam As End
 */
public class Test {

    public static void main(String[] args) throws Exception {
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost;user=sa;password=sam;");
    }

}
