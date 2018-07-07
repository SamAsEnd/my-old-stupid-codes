package com.samasend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GradeConverter extends JFrame {

    JLabel prom;
    JTextField input;
    JLabel result;
    JButton go;

    public GradeConverter() {
        super("Samson Endale");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        prom = new JLabel("Enter your grade");

        input = new JTextField(10);
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc();
            }
        });
        input.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                update();
            }
        });

        go = new JButton("GO");

        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc();
            }
        });

        result = new JLabel();
        result.setFont(new Font("Courier New", Font.BOLD, 20));

        add(prom);
        add(input);
        add(go);
        add(result, BorderLayout.SOUTH);

    }

    private void calc() {
        float grade = 0;
        try {
            grade = Float.parseFloat(input.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        char g;
        try {
            g = getChar(grade);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        result.setText("<html>Your grade is <font color='" + getColor(g) + "'>'" + g + "'</font>");
    }

    private void update() {
        result.setText("");
        result.setFont(new Font("Courier New", Font.BOLD, 20));
    }

    private char getChar(float grade) throws Exception {
        if (grade > 100) {
            throw new Exception("Must be <= 100");
        } else if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else if (grade >= 50) {
            return 'E';
        } else if (grade >= 0) {
            return 'F';
        } else {
            throw new Exception("Must be >= 0");
        }
    }

    private String getColor(char g) {
        if (g == 'F') {
            return "red";
        } else if (g == 'E' || g == 'D') {
            return "yellow";
        } else {
            return "green";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeConverter().setVisible(true);
            }
        });
    }
}
