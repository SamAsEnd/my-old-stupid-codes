package com.samasend;

import com.mysql.jdbc.Driver;
import java.awt.EventQueue;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;

public class Start {

    private static Connection connection = null;

    public static void main(String[] args) {

        try {
            Driver.class.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            couldNotConnect(ex.getMessage());
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/samasend", "root", null);
        } catch (SQLException ex) {
            couldNotConnect(ex.getMessage());
        }
        if (connection == null) {
            couldNotConnect("Unknown ERROR");
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception ex) {
                }
                new GUI("Sam As End", connection).setVisible(true);
            }
        });
    }

    public static void couldNotConnect(String str) {
        JOptionPane.showMessageDialog(null, str, "couldNotConnect", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
    
    public static final int SOUND_ERROR = 0;
    public static final int SOUND_EXIT = 1;
    public static final int SOUND_GOOD = 2;
    
    
    public static void play(int i) {
        InputStream inputStream;
        switch (i) {
            case SOUND_ERROR:
                inputStream = Class.class.getResourceAsStream("/com/samasend/error.wav");
                break;
            case SOUND_EXIT:
                inputStream = Class.class.getResourceAsStream("/com/samasend/exit.wav");
                break;
            case SOUND_GOOD:
                inputStream = Class.class.getResourceAsStream("/com/samasend/drip.au");
                break;
            default:
                return;
        }
        play(inputStream);
    }

    public static void play(InputStream inputStream) {
        AudioPlayer.player.start(inputStream);
    }
}
