/*
 * By:- Dejen Agaziu
 *        Ermiyas Birhanu
 *        Hassen Aliye
 *        Bahir Dar University Institute of Technology
 *        Department of Information Technology
 *        Distributed System group project
 */
package atm;
import java.sql.*;
public class DBCon {
    public Connection con;
    public DBCon(){
      try{
       Class.forName("com.mysql.jdbc.Driver");
       con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
      }catch(Exception e){}
  }
}
