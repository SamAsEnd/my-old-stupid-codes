package com.roby;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JFrame;

public class ClientSock {

    public static void main(String[] args) throws UnknownHostException, IOException {
        JFrame jFrame = new JFrame("Sam As End");
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jFrame.setVisible(true);
    }
}
