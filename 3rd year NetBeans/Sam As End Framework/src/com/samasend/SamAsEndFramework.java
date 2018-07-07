package com.samasend;

import javax.swing.Timer;

/**
 *
 * @author SamAsEnd
 */
public class SamAsEndFramework {

    static GUI gui;
    
    public SamAsEndFramework() {
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GUI("Sam as End");
                gui.setVisible(true);
            }
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                KeyActionMouseAdapter kama = new KeyActionMouseAdapter(gui);
                new Timer(50, kama).start();
            }
        });
    }
}
