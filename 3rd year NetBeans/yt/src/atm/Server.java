/*
 * By:-   Dejen Agaziu
 *        Ermiyas Birhanu
 *        Hassen Aliye
 *        Bahir Dar University Institute of Technology
 *        Department of Information Technology
 *        Distributed System group project
 */
package atm;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Server implements Runnable {

    private ServerSocket server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String pwd;
    private int balance;

    public Server() {
        try {
            server = new ServerSocket(6000);
            while (true) {
                socket = server.accept();
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                Thread t = new Thread(this);
                t.start();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void run() {
        try {
            String msg = in.readUTF();
            StringTokenizer str = new StringTokenizer(msg, ",");
            String str1 = str.nextToken();
            String str2 = str.nextToken();
            if (str2.equalsIgnoreCase("login")) {
                DBCon c = new DBCon();
                Statement stmt = c.con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from atmaccount");
                int f = 0;
                while (rs.next()) {
                    if (str1.equalsIgnoreCase(rs.getString(1))) {
                        f = 1;
                        break;
                    }
                }
                if (f == 1 || true) {
                    out.writeUTF("succefull");
                    pwd = rs.getString("Pin_Code");
                } else {
                    out.writeUTF("Wrong pin code");
                }
            } else if (str2.equalsIgnoreCase("deposit")) {
                int incoming = Integer.parseInt(str1);
                DBCon c = new DBCon();
                Statement stmt = c.con.createStatement();
                ResultSet rs = stmt.executeQuery("select Balance from ATMAccount where Pin_Code = '" + pwd + "'");
                int balances = 1;
                while (rs.next()) {
                    balance = rs.getInt("Balance");
                    if (balances == 1) {
                        break;
                    }
                }
                balance = balance + incoming;
                String query = "update ATMAccount set Balance = " + balance + " where Pin_Code='" + pwd + "'";
                stmt.executeUpdate(query);
                out.writeUTF("Current Balance after Deposit="+balances);
                JOptionPane.showMessageDialog(null, "your current balance is=" + balance + " and deposit amount=" + incoming, "Success", JOptionPane.ERROR_MESSAGE);
            } else if (str2.equalsIgnoreCase("withdraw")) {
                int incoming = Integer.parseInt(str1);
                DBCon c = new DBCon();
                Statement stmt = c.con.createStatement();
                ResultSet rs = stmt.executeQuery("select Balance from ATMAccount where Pin_Code = '" + pwd + "'");
                int balances = 1;
                while (rs.next()) {
                    balance = rs.getInt("Balance");
                    if (balances == 1) {
                        break;
                    }
                }
                balance = balance - incoming;
                String query = "update ATMAccount set Balance = " + balance + " where Pin_Code='" + pwd + "'";
                stmt.executeUpdate(query);
                out.writeUTF("Current Balance after Withdraw=");
                JOptionPane.showMessageDialog(null, "your current balance is=" + balance + " Withdraw amount=" + incoming, "Success", JOptionPane.ERROR_MESSAGE);
            } else if (str2.equalsIgnoreCase("view")) {
                DBCon c = new DBCon();
                Statement stmt = c.con.createStatement();
                ResultSet rs = stmt.executeQuery("select Balance from ATMAccount where Pin_Code='" + pwd + "'");
                int balances = 1;
                while (rs.next()) {
                    balance = rs.getInt("Balance");
                    if (balances == 1) {
                        break;
                    }
                }
                out.writeUTF("view = "+balances);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
