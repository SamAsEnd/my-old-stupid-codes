package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sun.rmi.log.LogInputStream;

public class GUI {

    public static void main(String[] args) {
        final JFrame login = new JFrame("Login");
        final JFrame other = new JFrame("Other");
        
        ArrayList<JFrame> arrayList = new ArrayList<>();
        
        arrayList.add(login);
        arrayList.add(other);
        
        for (Iterator<JFrame> it = arrayList.iterator(); it.hasNext();) {
            JFrame jFrame = it.next();
            jFrame.setSize(480, 360);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setResizable(Boolean.FALSE);
            jFrame.setLayout(new FlowLayout());
            jFrame.setLocationRelativeTo(null);
        }
        
        arrayList.clear();
        arrayList = null;
        
        JLabel jLabel1 = new JLabel("Usename");
        final JTextField jTextField1 = new JTextField(40);
        JLabel jLabel2 = new JLabel("Password");
        final JTextField jTextField2 = new JTextField(40);
        final JLabel jLabel3 = new JLabel(" ");
        jLabel3.setForeground(Color.red);
        
        JButton jButton = new JButton("Login");
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( pass()) {
                    login.setVisible(false);
                    other.setVisible(true);
                }
                else {
                    jLabel3.setText("Incorect Password");
                } 
            }
            private boolean pass() {
                if(jTextField1.getText().equals("SamAsEnd") && jTextField2.getText().equals("1234")) {
                    jTextField1.setText(" ");
                    jTextField2.setText(" ");
                    return true;
                }
                return false;
            }
        });
        
        login.add(jLabel1);
        login.add(jTextField1);
        login.add(jLabel2);
        login.add(jTextField2);
        login.add(jLabel3);
        login.add(jButton);
        
        JButton jButton1 = new JButton("Back");
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel3.setText(" ");
                login.setVisible(true);
                other.setVisible(false);
            }
        });
        other.setBackground(Color.BLACK);
        other.add(jButton1);
        
        login.setVisible(true);
    }
}