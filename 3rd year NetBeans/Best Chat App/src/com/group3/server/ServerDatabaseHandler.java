package com.group3.server;

import com.group3.ServerCommand;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**

 @author SamAsEnd
 */
public class ServerDatabaseHandler {

    private static Connection connection;
    private static PreparedStatement selectMessage;

    static {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            connection = DriverManager.getConnection("jdbc:sqlite:message.sqlite");
            selectMessage = connection.prepareStatement("select * from Message "
                    + "where id > ? and  fromUser LIKE '%?%' and toUser LIKE '%?%' and toUser LIKE 'ALL' "
                    + "order by sentTime ASC");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadMessageAfter(String name, PrintStream out, int lastMessageIndex) {
        try {
            int id = lastMessageIndex;
            selectMessage.setInt(1, lastMessageIndex);
            selectMessage.setString(2, name);
            selectMessage.setString(3, name);
            ResultSet rslt = selectMessage.executeQuery();
            while (rslt.next()) {
                id = rslt.getInt("id");
                String from = rslt.getString("fromUser");
                String to = rslt.getString("toUser");
                String message = rslt.getString("message");
                out.println("<div class='message' style='text-align: left; left: 0'>\n"
                        + "            <i>" + from + "</i>\n"
                        + "            <i style='display: block'>" + to + "</i>\n"
                        + "            <p>\n"
                        + message
                        + "            </p>    \n"
                        + "        </div>");
            }
            out.write(ServerCommand.STOP_READING);
            out.write(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private ServerDatabaseHandler() {
    }

}
