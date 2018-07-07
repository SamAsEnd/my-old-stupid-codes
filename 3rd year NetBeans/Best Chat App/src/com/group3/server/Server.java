package com.group3.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static void main(String[] args) throws IOException {
        new Server().start();
    }
    
    boolean listening_port = false;
    private ServerSocket server;
    
    public Server() throws IOException {
        server = new ServerSocket(21210);
    }
    
    synchronized public void run(){
        while (true) {           
            try {
                listening_port = true;
                notifyAll();
                Socket client = server.accept();
                new ServedClient(client).start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isListening_port() {
        return listening_port;
    }

}
