package com.samasend;

import java.awt.EventQueue;

public class MirkanaCounter {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}
