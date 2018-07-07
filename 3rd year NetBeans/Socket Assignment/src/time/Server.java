package time;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public static void main(String[] args) throws IOException {
        new Server(21021).start();
    }

    private void start() throws IOException {
        while (true) {
            try (Socket client = serverSocket.accept()) {
                PrintStream out = new PrintStream(client.getOutputStream());

                out.println(new Date().toGMTString());
            }
        }
    }
    
}
