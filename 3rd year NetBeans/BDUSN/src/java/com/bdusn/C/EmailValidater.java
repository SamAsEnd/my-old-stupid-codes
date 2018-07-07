package com.bdusn.C;

import com.bdusn.M.UserModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidater {

    private static Pattern emailNamePtrn = Pattern.compile(
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    private EmailValidater() {
    }

    public static boolean validateEmailAddress(String email) {
        Matcher matcher = emailNamePtrn.matcher(email);
        return matcher.matches() && !UserModel.emailExist(email);
    }

    public static String ajaxValidateEmailAddress(String email) {
        Matcher matcher = emailNamePtrn.matcher(email);
        if (!matcher.matches()) {
            return "Invalid Email";
        } else if (UserModel.emailExist(email)) {
            return "Email already exist";
        }
        return "OK";
    }

    public static void main(String[] args) {
        System.out.println(validateEmailAddress("4sam21@gmail.com"));           // false
        System.out.println(validateEmailAddress("4sam21gmail.com"));            // false
        System.out.println(validateEmailAddress("4sasd@hfsjhkfskjdf.com"));     // true
    }
}
