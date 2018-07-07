package calc;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.InvalidParameterException;
import java.util.Scanner;

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
                Scanner scanner = new Scanner(client.getInputStream());
                PrintStream out = new PrintStream(client.getOutputStream());

                String opration = scanner.nextLine();
                int first = scanner.nextInt();
                int second = scanner.nextInt();

                try {
                    int result = calc(opration, first, second);
                    out.println(result);
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        }
    }

    private int calc(String opration, int first, int second) {
        switch (opration) {
            case "add":
                return first + second;
            case "sub":
                return first - second;
            case "mul":
                return first * second;
            case "div":
                return first / second;
            default:
                throw new InvalidParameterException(opration + " is not an opration");
        }
    }
}
