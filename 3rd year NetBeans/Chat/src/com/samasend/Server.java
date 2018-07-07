package com.samasend;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SamAsEnd
 */
public class Server extends Thread {

    private ServerSocket socket;

    public Server() {
        try {
            socket = new ServerSocket(80);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket s = socket.accept();
                RecievedSock recievedSock = new RecievedSock(s);
                new Thread(recievedSock).start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
