package time;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public static void main(String[] args) throws IOException {
        new Client("localhost", 21021).start();
    }

    private void start() throws IOException {
        Scanner serverIn = new Scanner(socket.getInputStream());

        System.out.println("Server Time: " + serverIn.nextLine());
    }

}
