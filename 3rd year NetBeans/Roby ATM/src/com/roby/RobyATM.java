package com.roby;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RobyATM {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        Scanner cin = new Scanner(System.in);
        while (true) {            
            try {
                System.out.println("Lisning . . .");
                Socket accept = serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                String s = null;
                while((s=br.readLine()) != null) {
                    System.out.println(s);
                    if("".equals(s.trim())) {
                        break;
                    }
                }
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bw.write("HTTP/1.1 200 OK\n"
                        + "Connection: keep-alive\n"
                        + "Content-Type: text/html");
                bw.newLine();
                System.out.println("Enter: ");
                s = cin.nextLine();
                br.close();
                bw.write(s);
                bw.close();
                accept.close();
            } catch (Exception e) {
            }
        }
    }
    
}