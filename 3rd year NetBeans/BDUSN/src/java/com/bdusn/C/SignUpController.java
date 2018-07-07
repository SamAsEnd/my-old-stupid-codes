package com.bdusn.C;

import com.bdusn.M.DataBaseConnecter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class SignUpController {

    private static PreparedStatement insert;

    static {
        try {
            insert = DataBaseConnecter.connection.prepareStatement("INSERT INTO [User](email, pass, firstName, lastName, sex, dateOfBirth)\n"
                    + "VALUES (?,?,?,?,?,?)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean insert(User user) {
        try {
            insert.setString(1, user.getEmail());
            insert.setString(2, user.getPass());
            insert.setString(3, user.getFirstName());
            insert.setString(4, user.getLastName());
            insert.setString(5, "" + user.getSex());
            insert.setDate(6, Date.valueOf(user.getDateOfBirth()));

            return insert.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
