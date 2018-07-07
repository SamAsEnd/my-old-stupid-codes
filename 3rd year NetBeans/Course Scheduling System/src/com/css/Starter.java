package com.css;

import com.css.view.Home;
import java.awt.EventQueue;

public class Starter {

    public static void main(String[] args) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ignore) {
        }
        //</editor-fold>        
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Home home = new Home();
                home.setLocationRelativeTo(null);
                home.setVisible(true);
            }
        });
    }
}
