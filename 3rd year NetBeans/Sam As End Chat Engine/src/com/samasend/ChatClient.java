/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.net.NetworkClient;

/**
 *
 * @author SamAsEnd
 */
public class ChatClient {

    private HashMap<String, Socket> list;

    public ChatClient() {
        //Inet4Address.
    }

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> net = NetworkInterface.getNetworkInterfaces();
            while(net.hasMoreElements()) {
                NetworkInterface next = net.nextElement();
                System.out.println("" + next.getDisplayName());
                
            }
            System.out.println(Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException | SocketException ex) {
        }

    }
}
