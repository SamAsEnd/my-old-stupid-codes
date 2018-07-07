package model;

import controller.Employee;
import controller.Item;
import controller.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {

    public static boolean validateUsernameAndPassword(Employee employee) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT * FROM Employee WHERE username=? AND password=?");
            select.setString(1, employee.getUsername());
            select.setString(2, employee.getPassword());
            ResultSet resultSet = select.executeQuery();
            if (resultSet.next()) {
                employee.setSsn(resultSet.getInt("ssn"));
                employee.setFname(resultSet.getString("fname"));
                employee.setLname(resultSet.getString("lname"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSex(resultSet.getString("sex"));
                employee.setAge(resultSet.getInt("age"));
                employee.setSalary(resultSet.getFloat("salary"));
                employee.setUsername(resultSet.getString("username"));
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }

    public static ArrayList<Employee> selectAllEmployee() {
        ArrayList<Employee> list = new ArrayList<Employee>();
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT * FROM Employee");
            ResultSet resultSet = select.executeQuery();

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setSsn(resultSet.getInt("ssn"));
                employee.setFname(resultSet.getString("fname"));
                employee.setLname(resultSet.getString("lname"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSex(resultSet.getString("sex"));
                employee.setAge(resultSet.getInt("age"));
                employee.setSalary(resultSet.getFloat("salary"));
                employee.setUsername(resultSet.getString("username"));
                list.add(employee);
            }
            return list;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static boolean deleteEmployeeById(Employee e) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement delete;
            delete = connection.prepareStatement("DELETE FROM Employee WHERE ssn=?");
            delete.setInt(1, e.getSsn());
            int rows = delete.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
        }
        return false;
    }

    public static boolean insertEmployee(Employee e) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT INTO dbo.EMPLOYEE "
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");
            insert.setInt(1, e.getSsn());
            insert.setString(2, e.getFname());
            insert.setString(3, e.getLname());
            insert.setString(4, e.getPosition());
            insert.setString(5, e.getSex());
            insert.setInt(6, e.getAge());
            insert.setFloat(7, e.getSalary());
            insert.setString(8, e.getUsername());
            insert.setString(9, e.getPassword());
            int rows = insert.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    /* public static ArrayList<Customer> selectRoomreservedCustomer() {
     ArrayList<Customer> list = new ArrayList<Customer>();
     try {
     DatabaseConnecter databaseConnecter = new DatabaseConnecter();
     Connection connection = databaseConnecter.getConnection();
     PreparedStatement select = connection.prepareStatement("SELECT SSN,FName,LName,BName,RoomNumber,"
     + "Start_Date,End_date FROM CUSTOMER s,BRANCHE b,ROOM r,RESERVATION_DATE rd where "
     + "s.SSN=rd.CSSN and r.RoomNumber=rd.RoomNum and b.BNO=rd.BNo");

     ResultSet resultSet = select.executeQuery();

     while (resultSet.next()) {

     list.add((Customer) resultSet);
     }
     return list;
     }
     catch (SQLException ex) {
     ex.printStackTrace();
     }
     return null;
     }*/

    public static boolean insertItem(Supplier s) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement insert = connection.prepareStatement("INSERT INTO dbo.SUPPLIER "
                    + "	VALUES (?, ?, ?, ?, ?) ");
            insert.setInt(1, s.getOrgId());
            insert.setString(2, s.getOrgName());
            insert.setInt(3, s.getItemId());
            insert.setInt(4, s.getQuantity());
            insert.setFloat(5, s.getPrice());
            int rows = insert.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Item> selectExpiredItem() {
        ArrayList<Item> expItem = new ArrayList<Item>();
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT Name,ExpDate FROM ITEM where ExpDate");
            ResultSet resultSet = select.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setName(resultSet.getString("name"));
                item.setExpDate(resultSet.getDate("expDate"));

                expItem.add(item);
            }
            return expItem;
        } catch (SQLException ex) {
        }
        return null;
    }

}
