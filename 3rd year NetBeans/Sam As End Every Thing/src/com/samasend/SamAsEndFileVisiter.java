package com.samasend;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SamAsEndFileVisiter extends SimpleFileVisitor<Path> {

    private Statement stmt;

    public static int nuberOfFileVisiter = 0;
    
    public SamAsEndFileVisiter(Statement stmt) {
        nuberOfFileVisiter++;
        this.stmt = stmt;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        try {
            getStmt().execute("INSERT INTO `file` (`id`, `fileName`, `filePath`) "
                    + "VALUES (NULL, '" + file.getFileName().toString().replace('\\', '/') + "', "
                    + "'" + file.toString() + "');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        System.out.printf("%1d %7d - file - %s\n",nuberOfFileVisiter, (Main.count++), file.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        String sql = "INSERT INTO `file` (`id`, `fileName`, `filePath`) "
                    + "VALUES (NULL, '" + dir.getFileName() + "', "
                    + "'" + dir.toString() + " ');";
        try {
            boolean execute;
            execute = getStmt().execute(sql);      
        } catch (SQLException ex) {
            System.err.println("\n\n\n"+sql+"\n\n\n");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.printf("%1d %7d - file - %s\n",nuberOfFileVisiter, (Main.count++), dir.toString());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if(nuberOfFileVisiter < 1000) {
            SamAsEndFileVisiter samAsEndFileVisiter = new SamAsEndFileVisiter(stmt);
            
            new VisiterThread(dir, samAsEndFileVisiter).start();
            
            return FileVisitResult.SKIP_SUBTREE;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    /**
     * @return the stmt
     */
    public Statement getStmt() {
        return stmt;
    }

    /**
     * @param stmt the stmt to set
     */
    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}
