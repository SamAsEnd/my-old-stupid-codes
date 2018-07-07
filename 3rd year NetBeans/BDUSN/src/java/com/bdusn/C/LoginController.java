package com.bdusn.C;

import com.bdusn.E.UserNotFoundException;

public final class LoginController {

    private User user;

    public LoginController(String email, String pass) {
        try {
            user = User.getUserByEmailAndPass(email, pass);
        } catch (UserNotFoundException ex) {
            user = null;
        }
    }

    public User getUser() {
        return user;
    }
}
