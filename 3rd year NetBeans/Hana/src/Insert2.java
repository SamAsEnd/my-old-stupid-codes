  import java.sql.*;
 
  public class Insert2 {
    public static void main(String[] args)
       throws SQLException, ClassNotFoundException {
     // Load the JDBC driver
     Class.forName("com.mysql.jdbc.Driver");
     System.out.println("Driver loaded");

    // Establish a connection
    Connection connection = DriverManager.getConnection
     ("jdbc:mysql://localhost:3306/employeeMGTSYS","root", "");
    System.out.println("Database connected");

    // Create a statement
    Statement statement = connection.createStatement();
    // Execute a statement
    ResultSet resultSet = statement.executeQuery
      ("select fname, employid, dept from employee where fname "
        + " = 'worineh'");

    // Iterate through the result and print the student names
    while (resultSet.next())
     System.out.println(resultSet.getString(1) + "\t" +
         resultSet.getString(2) + "\t" + resultSet.getString(3));

    // Close the connection
     connection.close();
   }
 }
