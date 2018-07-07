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
    String url="sun.jdbc.odbc.JdbcOdbcDriver";
    String ds="jdbc:odbc:jj";
    public JDBC() throws Exception{
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con=DriverManager.getConnection("jdbc:odbc:jj");

    }

}
