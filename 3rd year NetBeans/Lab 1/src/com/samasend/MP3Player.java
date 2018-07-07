package com.samasend;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MP3Player extends Thread {

    private static final Stack<MP3Player> players;

    static {
        players = new Stack<>();
    }

    public static void closeAll() {
        for (MP3Player mP3Player : players) {
            mP3Player.close();
        }
        players.clear();
    }

    public static boolean isPlaying() {
        return !players.empty();
    }

    static boolean isCleaningUp() {

        return players.empty();
    }

    private final InputStream is;
    private Player player;

    public MP3Player(InputStream is) {
        players.add(this);
        this.is = is;
    }

    public void close() {
        try {
            is.reset();
        } catch (IOException ex) {
        }
        if (player != null) {
            player.close();
            players.remove(this);
        }
        closeAll();
        System.gc();
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
    }

    @Override
    public void run() {
        try {
            BufferedInputStream bis = new BufferedInputStream(is);
            player = new Player(bis);
            player.play();
        } catch (JavaLayerException ex) {
            JOptionPane.showMessageDialog(
                    null, "Come on take it easy!!!\n"
                    + "Change the country and try again later",
                    "Something went wrong",
                    JOptionPane.WARNING_MESSAGE);
            players.remove(this);
            closeAll();
        }
    }
}
