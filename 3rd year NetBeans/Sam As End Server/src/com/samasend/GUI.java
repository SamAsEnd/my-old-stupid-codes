/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SamAsEnd
 */
public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
        setVisible(true);
        server();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt.setEditable(false);
        jScrollPane1.setViewportView(txt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txt;
    // End of variables declaration//GEN-END:variables
    ServerSocket server;
    Socket sock;

    private void server() {
        System.out.println("server()");
        StringBuilder sb = new StringBuilder();
        try {
            server = new ServerSocket(80);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.exit(0);
        }
        System.out.println("new ServerSocket(80);");
        while (true) {
            try {
                sock = server.accept();
                System.out.println("server.accept();");
                InputStream is = sock.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                sb.delete(0, sb.capacity());
                String buff = "";
                while (!"".equals(buff = br.readLine())) {
                    sb.append(buff);
                    System.out.println(buff);
                }
                System.out.println("\nDone reading!!");
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
                bw.write("HTTP/1.1 200 OK\n"
                        + "Date: Wed, 13 Sep 2000 20:29:50 GMT\n"
                        + "Server: Apache/1.3.12 (Unix)\n"
                        + "Last-Modified: Tue, 05 Sep 2000 06:52:39 GMT\n"
                        + "ETag: \"a9260-18a-39b49837\"\n"
                        + "Accept-Ranges: bytes\n"
                        + "Content-Length: 394\n"
                        + "Content-Type: text/html\n"
                        + "\n"
                        + "<HTML>\n"
                        + "<!--- Dave Reed index.html 8/17/00 -->\n"
                        + "<!--------------------------------------------------->\n"
                        + "<HEAD>\n"
                        + "<TITLE>Dave Reed's Home Page</TITLE>\n"
                        + "<SCRIPT LANGUAGE=\"JavaScript\">\n"
                        + "if (self!=top) \n"
                        + "top.location.href=self.location.href;\n"
                        + "</SCRIPT>\n"
                        + "</HEAD>\n"
                        + "<FRAMESET COLS=\"170,*\">\n"
                        + "<FRAME SRC=\"menu.html\" NAME=\"menu\">\n"
                        + "<FRAME SRC=\"info.html\" NAME=\"main\">\n"
                        + "</FRAMESET>\n"
                        + "</HTML>");
                //bw.newLine();
                //bw.write("Req:\n" + sb.toString());
                try {
                    is.close();
                    br.close();
                    bw.close();
                    sock.close();
                } catch (IOException iOException) {
                }
            } catch (Exception e) {
            }
        }
    }
}