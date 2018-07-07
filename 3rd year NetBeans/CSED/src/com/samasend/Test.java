package com.samasend;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Test {

    public Test() {
        JFrame frame = new JFrame("Calculater");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 360);
        //frame.setSize(1366, 768);
        frame.setLayout(new FlowLayout());
        /*try {
         * UIManager.setLookAndFeel(new NimbusLookAndFeel());
         * } catch (UnsupportedLookAndFeelException ex) {
         * System.out.println(ex.toString());
         * }*/
        frame.setUndecorated(true);
        //frame.setBackground(Color.BLACK);
        //frame.setLocationRelativeTo(null);
        //frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        final JTextField first = new JTextField(6);
        String[] opList = {"+", "-", "*", "/"};
        /*final JList op = new JList(opList);
         * 
         * JScrollPane pane = new JScrollPane(op);
         * pane.setPreferredSize(new Dimension(35, 20));
         * 
         * op.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
         */
        final JComboBox<String> op = new JComboBox<>(opList);
        
        final JTextField second = new JTextField(6);
        JButton eq = new JButton("=");
        final JLabel ans = new JLabel("");
        final JLabel status = new JLabel("");
        status.setForeground(Color.red);

        eq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                status.setText("");
                int f = 0;
                int s = 0;
                try {
                    String ff = first.getText();
                    String ss = second.getText();
                    if(ff == null || ff.equals("")) {
                        status.setText("Enter the first oprand");
                        return;
                    }
                    if(ss == null || ss.equals("")) {
                        status.setText("Enter the second oprand");
                        return;
                    }
                    f = Integer.parseInt(ff);
                    s = Integer.parseInt(ss);
                } catch (NumberFormatException numberFormatException) {
                    status.setText("Error: "+numberFormatException.toString());
                    return;
                }
                int selectedIndex = op.getSelectedIndex();
                if (selectedIndex == -1) {
                    status.setText("Please select the operater");
                    return;
                } else if (selectedIndex == 0) {
                    ans.setText("" + (f + s));
                } else if (selectedIndex == 1) {
                    ans.setText("" + (f - s));
                } else if (selectedIndex == 2) {
                    ans.setText("" + (f * s));
                } else if (selectedIndex == 3) {
                    ans.setText("" + ((float) f / s));
                } else {
                    status.setText("Operater unknown");
                }
            }
        });
        
        //<editor-fold defaultstate="collapsed" desc="just just just">
        ArrayList<JComponent> r = new ArrayList<>();
        r.add(first);
        r.add(op);
        r.add(second);
        r.add(eq);
        
        for (JComponent jComponent : r) {
            jComponent.addFocusListener(new FocusListener() {
                
                public void focusGained(FocusEvent e) {
                    status.setText("");
                }
                
                public void focusLost(FocusEvent e) { }
            });
        }
        //</editor-fold>
        
        frame.add(first);
        //frame.add(pane);
        frame.add(op);
        frame.add(second);
        frame.add(eq);
        frame.add(ans);
        frame.add(status);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test();
            }
        });
    }
}
