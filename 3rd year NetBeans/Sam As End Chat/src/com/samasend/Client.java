/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * @author SamAsEnd
 */
public class Client implements Runnable {

    private Socket socket;
    private JTextPane pane;
    private String msg;

    public Client(Socket socket, JTextPane pane, String msg) {
        this.socket = socket;
        this.pane = pane;
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            BufferedWriter bufferedWriter = null;
            BufferedReader bufferedReader = null;
            String respons;
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                int i = 0;
                do {
                    bufferedWriter.write(msg.toCharArray());
                    respons = bufferedReader.readLine();
                    ++i;
                    if(i > 3) {
                        JOptionPane.showMessageDialog(null, "Can't send msg!!");
                        break;
                    }
                } while ("OK".equals(respons));
            } catch (IOException ex) {
            } finally {
                try {
                    bufferedWriter.close();
                    bufferedReader.close();
                    socket.close();
                } catch (Exception ex) {
                }
            }
            Thread.currentThread().join();
        } catch (InterruptedException ex) {}
    }
}
