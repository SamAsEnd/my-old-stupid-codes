package com.samasend;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stmt = null;

        Class.forName("com.mysql.jdbc.Driver");

        conn = DriverManager.getConnection("jdbc:mysql://localhost/samasend", "root", null);

        stmt = conn.createStatement();

        SamAsEndFileVisiter visiter;

        visiter = new SamAsEndFileVisiter(stmt);
        Iterable<Path> rootDirectories = FileSystems.getDefault().getRootDirectories();

        for (Path path : rootDirectories) {

            new VisiterThread(path, visiter).start();
            
        }

    }
}
