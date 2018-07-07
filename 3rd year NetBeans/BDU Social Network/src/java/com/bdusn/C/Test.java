package com.bdusn.C;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String errorMsg = "";

        String emailString = "4sam21@gmail.com";
        String passwordString = "sami";

        LoginController loginController = new LoginController(emailString, passwordString);

        if (loginController.validate()) {
            errorMsg += loginController.getUserID();
        } else {
            errorMsg = "Invalid email and password";
        }

        System.out.println(errorMsg);
    }

}
