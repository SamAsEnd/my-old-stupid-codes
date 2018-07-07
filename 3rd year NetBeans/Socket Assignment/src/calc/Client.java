package calc;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public static void main(String[] args) throws IOException {
        while (true) {            
            new Client("localhost", 21021).start();
        }
    }

    private void start() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        PrintStream serverOut = new PrintStream(socket.getOutputStream());
        Scanner serverIn = new Scanner(socket.getInputStream());

        System.out.print("Enter the opration(add|sub|mul|div): ");
        String opration = keyboard.nextLine();
        System.out.print("Enter the  first: ");
        int first = keyboard.nextInt();
        System.out.print("Enter the second: ");
        int second = keyboard.nextInt();

        serverOut.println(opration);
        serverOut.println(first);
        serverOut.println(second);

        System.out.println("Result: " + serverIn.nextLine());
    }

}
