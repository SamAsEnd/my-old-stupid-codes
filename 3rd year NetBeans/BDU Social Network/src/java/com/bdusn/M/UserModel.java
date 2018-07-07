package com.bdusn.M;

import com.bdusn.C.UserNotFoundException;
import com.bdusn.C.oo.User_Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sam As End
 */
public class UserModel {

    private static DatabaseConnecter databaseConnecter;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet result;

    static {
        try {
            databaseConnecter = new DatabaseConnecter();
            connection = databaseConnecter.getConnection();
            statement = connection.createStatement();
        } catch (DataBaseConnectionException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static User_Class load(int userID) throws DataBaseConnectionException {
        User_Class user = null;
        String sql;
        if (validateUserID(userID)) {
            user = new User_Class(userID);
            //user.setUserID(userID);
        }
        return user;
    }

    public static void load(User_Class user) {
        String sql;

        if (validateUserID(user.getUserID())) {
            try {
                statement = connection.createStatement();
                sql = "SELECT * "
                        + "FROM [User] "
                        + "WHERE userID=" + user.getUserID();
                result = statement.executeQuery(sql);
                if (result.next()) {
                    user.setEmail(result.getString("email"));
                    user.setPass(result.getString("pass"));
                    user.setFirstName(result.getString("firstName"));
                    user.setLastName(result.getString("lastName"));
                    user.setSex(result.getString("sex"));
                    user.setAboutMe(result.getString("aboutMe"));
                    user.setReligion(result.getString("religion"));
                    user.setDateOfBirth(result.getDate("dateOfBirth").toLocalDate());
                    user.setCity(result.getString("city"));
                    user.setEducationalStatus(result.getString("educationalStatus"));
                    user.setMartialStat(result.getString("martialStatus"));
                    user.setPhoneNumber(result.getString("phoneNumber"));
                    user.setLastActiveTime(result.getTimestamp("lastActiveTime").toLocalDateTime());
                    user.setProPicture(result.getInt("proPicture"));
                    user.setActivated(result.getBoolean("activated"));
                } else {
                    throw new UserNotFoundException();
                }
            } catch (SQLException e) {
                //throw new DataBaseConnectionException();
                e.printStackTrace();
            }
        } else {
            user.setFirstName("Error");
        }
    }

    public static boolean validateUserID(int userID) {
        try {
            String sql = "SELECT * "
                    + "FROM [User] "
                    + "WHERE userID=" + userID;
            result = statement.executeQuery(sql);
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getUserID(String email, String pass) {
        try {
            String sql = "SELECT * "
                    + "FROM [User] "
                    + "WHERE email='" + email + "' AND "
                    + "pass='" + pass + "'";

//            String sql = "print dbo.authenticate(?,?)";
//            CallableStatement prepareCall = connection.prepareCall(sql);
//            result = prepareCall.executeQuery();
            result = statement.executeQuery(sql);
            if (result.next()) {
                return result.getInt("userID");
            } else {
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
