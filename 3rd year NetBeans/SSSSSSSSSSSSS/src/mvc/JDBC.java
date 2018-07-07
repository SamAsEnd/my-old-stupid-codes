/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author student
 */
public class JDBC {

    Connection con;
    String url = "com.mysql.jdbc.Driver";
    String ds = "jdbc:mysql://localhost/db";

    public JDBC() throws Exception {
        Class.forName(url);
        con = DriverManager.getConnection(ds,"root","");
    }
}
