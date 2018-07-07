package com.bdusn.C;

import com.bdusn.M.UserModel;

public class LoginController {

    private int userID;
    private String email;
    private String password;

    public LoginController(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public boolean validate() {
        userID = UserModel.getUserID(email, password);
        return userID != -1;
    }

    //<editor-fold defaultstate="collapsed" desc="getter and setters">
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
//</editor-fold>
}
