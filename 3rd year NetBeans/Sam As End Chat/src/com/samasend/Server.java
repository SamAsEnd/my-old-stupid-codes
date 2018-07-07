/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextPane;

/**
 *
 * @author SamAsEnd
 */
public class Server implements Runnable {

    private ServerSocket serverSocket;
    private JTextPane pane;

    public Server(JTextPane pane) throws IOException {
        this.pane = pane;
        serverSocket = new ServerSocket(SamAsEndChat.PORT);
    }

    @Override
    public void run() {
        Socket socket = null;
        InputStream in = null;
        byte[] buff = new byte[1024 * 1024];
        StringBuffer buffer;
        while (true) {
            try {
                socket = serverSocket.accept();
                pane.setText(pane.getText() + "\nNew Client connected: " + socket.getInetAddress().getHostName()
                        + "[" + socket.getInetAddress().getHostAddress() + "]");
                in = socket.getInputStream();
                buffer = new StringBuffer();
                while ((in.read(buff) != -1)) {
                    buffer.append(buff);
                }
                socket.getOutputStream().write("OK".getBytes());
                pane.setText(pane.getText() + "\nReceived: " + socket.getInetAddress().getHostName()
                        + "[" + socket.getInetAddress().getHostAddress() + "]\n" + buffer.toString());
            } catch (IOException ex) {
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException ex) {}
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {}
                }
            }
        }
    }
}
