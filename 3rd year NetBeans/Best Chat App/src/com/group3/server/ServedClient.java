package com.group3.server;

import com.group3.ClientCommand;
import java.io.*;
import java.net.*;
import java.util.HashMap;

/**

 @author SamAsEnd
 */
public class ServedClient extends Thread {

    public static void main(String[] args) throws IOException {
        new ServedClient(new Socket("localhost", 21210)).start();
    }

    private String name;
    private Socket socket;
    private PrintStream out;
    private BufferedReader in;

    private static final HashMap<String, ServedClient> clientList;

    static {
        clientList = new HashMap<>(10);
        try {
            // initializing th static contexts
            ServerDatabaseHandler.class.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ServedClient(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        name = in.readLine();
        clientList.put(name, this);
    }

    @Override
    public void run() {
        try {
//            new Thread(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            clientListener();
//                        }
//                    }).start();

            while (true) {
                int clientCommand = in.read();
                if (clientCommand == ClientCommand.GET_MESSAGE) {
                    if (in.read() == ClientCommand.MESSAGE_INDEX) {
                        getMessage();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

//    void clientListener() {
//
//    }
    private void getMessage() {
        int lastMessageIndex = 0;
        try {
            lastMessageIndex = in.read();
            loadMessage(lastMessageIndex);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadMessage(int lastMessageIndex) {
        ServerDatabaseHandler.loadMessageAfter(name,out,lastMessageIndex);
    }

}
