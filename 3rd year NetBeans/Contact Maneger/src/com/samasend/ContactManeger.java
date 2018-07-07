package com.samasend;

import com.samasend.GUI.MainUserInteface;

public class ContactManeger {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainUserInteface().setVisible(true);
            }
        });
    }
}
