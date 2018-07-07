package com.bdusn.M;

import com.bdusn.C.User;
import com.bdusn.E.UserNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public final class UserModel {

    private static PreparedStatement selectUserByID;
    private static PreparedStatement selectUserByEmailAndPass;
    private static PreparedStatement selectUserByEmail;

    static {
        try {
            selectUserByID = DataBaseConnecter.connection.prepareStatement("SELECT * "
                    + "FROM [User] "
                    + "WHERE userID = ?");
            selectUserByEmailAndPass = DataBaseConnecter.connection.prepareStatement("SELECT * "
                    + "FROM [User] "
                    + "WHERE email = ? AND pass = ?");
            selectUserByEmail = DataBaseConnecter.connection.prepareStatement("SELECT * "
                    + "FROM [User] "
                    + "WHERE email = ?");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadByID(User user) throws UserNotFoundException {
        try {
            selectUserByID.setInt(1, user.getUserID());
            ResultSet result = selectUserByID.executeQuery();
            if (result.next()) {
                resultsetToUserFill(result, user);
            } else {
                throw new UserNotFoundException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserNotFoundException();
        }
    }

    public static void loadByEmailAndPass(User user) throws UserNotFoundException {
        try {
            selectUserByEmailAndPass.setString(1, user.getEmail());
            selectUserByEmailAndPass.setString(2, user.getPass());
            ResultSet result = selectUserByEmailAndPass.executeQuery();
            if (result.next()) {
                resultsetToUserFill(result, user);
            } else {
                throw new UserNotFoundException();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new UserNotFoundException();
        }
    }

    public static boolean emailExist(String email) {
        try {
            selectUserByEmail.setString(1, email);
            ResultSet result = selectUserByEmail.executeQuery();
            return result.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static void resultsetToUserFill(ResultSet resultSet, User user) throws SQLException {
        user.setUserID(resultSet.getInt("userID"));
        user.setEmail(resultSet.getString("email"));
        user.setPass(resultSet.getString("pass"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setSex(resultSet.getString("sex").charAt(0));
        user.setAboutMe(resultSet.getString("aboutMe"));
        user.setReligion(resultSet.getString("religion"));
        user.setDateOfBirth(resultSet.getDate("dateOfBirth").toLocalDate());
        user.setCity(resultSet.getString("city"));
        user.setEducationalStatus(resultSet.getString("educationalStatus"));
        user.setMartialStatus(resultSet.getString("martialStatus"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));

        Timestamp timestamp = resultSet.getTimestamp("lastActiveTime");
        user.setLastActiveTime((timestamp != null) ? timestamp.toLocalDateTime() : null);
        user.setProPicture(resultSet.getInt("proPicture"));
        user.setActived(resultSet.getInt("actived"));
    }

    private UserModel() {
    }

}
