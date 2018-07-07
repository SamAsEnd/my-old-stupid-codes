package com.samasend;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SamAsEnd
 */
public class Server extends Thread {
    
    static StringBuffer txt;

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(21021);
        txt = new StringBuffer();
        while (true) {
            try {
                Socket s = server.accept();
                new Server(s).start();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public synchronized static String getTxt() {
        return txt.toString();
    }

    private Socket socket;
    private BufferedReader in;
    private DataOutputStream out;

    public Server(Socket socket) throws Exception {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                String _msg = in.readLine();
                System.out.println(_msg);
                if("_msg_".equals(_msg)) {
                    out.writeUTF(getTxt());
                    continue;
                }
                else if(_msg.contains("clrscr();")) {
                    txt = new StringBuffer();
                    out.writeUTF("OK");
                    continue;
                }
                txt = txt.append("<br>\n").append(_msg);
                out.writeUTF("OK");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
}
