package com.samasend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    static ArrayList<Tag> tags;

    public static void main(String args[]) throws Exception {
        tags = new ArrayList<Tag>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File("C:\\Users\\SamAsEnd\\Desktop\\HTML5Tags.txt"))));

        String buff = "";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/html", "root", "");
        Statement statement = conn.createStatement();
        while ((buff = reader.readLine()) != null) {
            try {
                process(buff);
            } catch (Exception ignore){}
        }
        synchronized (statement) {
            statement.executeUpdate("delete from tags");
        }
        for (Tag tag : tags) {
            String q = tag.toDataBaseInsert();
            try {
                if (statement.executeUpdate(q) == 0) {
                    throw new Exception("Error when excuting: ");
                } else {
                    System.out.println("Success");
                }
            } catch (Exception ex){
                System.err.println(ex.getMessage()+"\n"+ q);
                System.exit(0);
            }
        }
    }

    private static void process(String buff) throws Exception {

        tags.add(new Tag(buff));

    }

}
