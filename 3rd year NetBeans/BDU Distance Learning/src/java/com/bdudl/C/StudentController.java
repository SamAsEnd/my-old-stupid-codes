package com.bdudl.C;

import com.bdudl.M.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentController {

    public static String register(Student student) {
        String status;
        PreparedStatement insert = null;
        try {
            Connection connection = new DBConnect().getConnection();
            insert = connection.prepareStatement("INSERT INTO `student`\n"
                    + "(`fName`, `lName`, `sex`, `address`, `as`)\n"
                    + "VALUES (?,?,?,?,?)");

            insert.setString(1, student.getFirstName());
            insert.setString(2, student.getLastName());
            insert.setString(3, student.getSex());
            insert.setString(4, student.getAddress());
            insert.setInt(5, student.getAcadamicStatus());

            if (student.getAcadamicStatus() < 290) {
                status = "Acad. Status must be greater than 290";
            } else {
                int result = insert.executeUpdate();
                if (result > 0) {
                    status = "Successfully Inserted";
                } else {
                    status = "Not inserted";
                }
            }
        } catch (Exception e) {
            status = "Error " + e.getMessage();
        }
        return status;
    }

    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = new DBConnect().getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT *\n"
                    + "FROM `student`\n"
                    + "ORDER BY `student`.`as` DESC");
            ResultSet result = select.executeQuery();
            while (result.next()) {
                Student student = new Student();
                student.setId(result.getInt("id"));
                student.setFirstName(result.getString("fName"));
                student.setLastName(result.getString("lName"));
                student.setSex(result.getString("sex"));
                student.setAddress(result.getString("address"));
                student.setAcadamicStatus(result.getInt("as"));

                students.add(student);
            }
        } catch (Exception e) {
        }
        return students;

    }

    public static String deleteStudent(int id) {
        String status;
        try {
            Connection connection = new DBConnect().getConnection();
            PreparedStatement select = connection.prepareStatement("DELETE FROM student WHERE id = ?");

            select.setInt(1, id);

            int result = select.executeUpdate();
            if (result > 0) {
                status = "Successfully Delete";
            } else {
                status = "NOT Delete";
            }
        } catch (Exception e) {
            status = "Error " + e.getMessage();
        }
        return status;
    }

}
