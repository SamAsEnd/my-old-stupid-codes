package com.samasend.mysql;

import java.sql.ResultSet;
import java.sql.SQLException; 

public class Test {
    public static void main(String[] args) {
        MySQLConnection sql;
        sql = new MySQLConnection("samasend", "root", null);
        try {
            sql.executeUpdate("INSERT INTO `student`(`id`, `name`, `sex`, `dept`)"
                    + " VALUES (null,'xxxxxxx','F','EED')");
            ResultSet r = sql.executeQuery("select * from student");
            while (r.next()) {                
                int id = r.getInt("id");
                String name = r.getString("name");
                String sex = r.getString("sex");
                String dept = r.getString("dept");
                System.out.println(""+id);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
    }
        
}
