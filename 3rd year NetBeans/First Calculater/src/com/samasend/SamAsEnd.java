package com.samasend;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SamAsEnd extends JFrame {
    //----------- Buttons ------------------
    public JButton AddButton;
    public JButton SubButton;
    public JButton MutButton;
    public JButton DivButton;
    public JButton ModButton;
    
    //----------- Text Field --------------  
    public JTextField F;
    public JTextField S;
    public JTextField Ans;
    
    //----------- Label -------------------
    public JLabel AnswerL;

    //----------- Function -------------------
    public SamAsEnd() {
        
        //----------- Properties -------------------
        setTitle("Sam As End Calculator");
        setSize(new Dimension(410, 125));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        setResizable(false);
        addComponentListener(new ComponentListener() {
            public void componentHidden(ComponentEvent arg0) {
            }

            public void componentMoved(ComponentEvent arg0) {
            }

            public void componentResized(ComponentEvent arg0) {
            }

            public void componentShown(ComponentEvent arg0) {
                SamAsEnd_Load();
            }
        });

        this.AddButton = new JButton();
        this.AddButton.setText("Add");
        this.AddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ADD_P();
            }
        });

        this.MutButton = new JButton();
        this.MutButton.setText("Multiply");
        this.MutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MUT_P();
            }
        });

        this.DivButton = new JButton();
        this.DivButton.setText("Divide");
        this.DivButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Div_P();
            }
        });

        this.SubButton = new JButton();
        this.SubButton.setText("Substract");
        this.SubButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SUB_P();
            }
        });

        this.ModButton = new JButton();
        this.ModButton.setText("Modular");
        this.ModButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MOD_P();
            }
        });

        this.F = new JTextField();
        this.F.setText("                                                               ");

        this.S = new JTextField();
        this.S.setText("                                                               ");

        this.Ans = new JTextField();
        this.Ans.setText("                                                     ");
        this.Ans.setEditable(false);

        this.AnswerL = new JLabel();
        this.AnswerL.setText("Answer is: ");

        add(AddButton);
        add(SubButton);
        add(MutButton);
        add(DivButton);
        add(ModButton);
        add(F);
        add(S);
        add(AnswerL);
        add(Ans);

    }

    public void SamAsEnd_Load() {
        F.setText("");
        S.setText("");
        Ans.setText("");
    }

    public void ADD_P() {
        try {
            long num1, num2;
            num1 = Integer.parseInt(F.getText());
            num2 = Integer.parseInt(S.getText());
            long answr = num1 + num2;
            Ans.setText(String.valueOf(answr));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }
    }

    public void SUB_P() {
        try {
            long num1, num2;
            num1 = Integer.parseInt(F.getText());
            num2 = Integer.parseInt(S.getText());
            long answr = num1 - num2;
            Ans.setText(String.valueOf(answr));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }
    }

    public void MUT_P() {
        try {
            long num1, num2;
            num1 = Integer.parseInt(F.getText());
            num2 = Integer.parseInt(S.getText());
            long answr = num1 * num2;
            Ans.setText(String.valueOf(answr));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }
    }

    public void Div_P() {
        try {
            double num1, num2;
            num1 = Integer.parseInt(F.getText());
            num2 = Integer.parseInt(S.getText());
            double answr = num1 / num2;
            Ans.setText(String.valueOf(answr));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }
    }

    public void MOD_P() {
        try {
            int num1, num2;
            num1 = Integer.parseInt(F.getText());
            num2 = Integer.parseInt(S.getText());
            int answr = num1 % num2;
            Ans.setText(String.valueOf(answr));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }
    }
}
