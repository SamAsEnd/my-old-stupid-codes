/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apple;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tedy
 */
public class Login extends javax.swing.JFrame {

    public static Connection connection;
    private PreparedStatement mgrLogin;
    private PreparedStatement casherLogin;
    private PreparedStatement storeKeeperLogin;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/asm", "root", "");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public Login() {
        try {
            initComponents();
            setLocationRelativeTo(null);

            mgrLogin = connection.prepareStatement("SELECT * FROM manager "
                    + "where mEmail = ? "
                    + "AND mPassword = ?");
            casherLogin = connection.prepareStatement("SELECT * FROM casher "
                    + "where cEmail = ? "
                    + "AND cPassword = ?");
            storeKeeperLogin = connection.prepareStatement("SELECT * FROM storekeeper "
                    + "where skEmail = ? "
                    + "AND skPassword = ?");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emailLable = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordLable = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/apple/logo2.png"))); // NOI18N
        jLabel1.setText(" ");

        emailLable.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        emailLable.setText("Email");

        emailField.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailFieldKeyTyped(evt);
            }
        });

        passwordLable.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        passwordLable.setText("Password");

        login.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        status.setBackground(new java.awt.Color(204, 204, 204));
        status.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(186, 0, 0));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLable)
                            .addComponent(emailLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(passwordField)
                            .addComponent(emailField))))
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLable)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLable)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login)
                .addGap(18, 18, 18)
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed

        String email = emailField.getText();
        String pass = new String(passwordField.getPassword());
        try {

            mgrLogin.setString(1, email);
            mgrLogin.setString(2, pass);
            ResultSet mgrResult = mgrLogin.executeQuery();
            if (mgrResult.next()) {
                int mgrId = mgrResult.getInt("mId");
                SwingUtilities.invokeLater(new MgrGUI(mgrId));
                dispose();
            }

            casherLogin.setString(1, email);
            casherLogin.setString(2, pass);
            ResultSet casherResult = casherLogin.executeQuery();
            if (casherResult.next()) {
                int casherId = casherResult.getInt("cId");
                EventQueue.invokeLater(new CasherGUI(casherId));
                dispose();
            }

            storeKeeperLogin.setString(1, email);
            storeKeeperLogin.setString(2, pass);
            ResultSet storeKeeperResult = storeKeeperLogin.executeQuery();
            if (storeKeeperResult.next()) {
                int storeKeeperId = storeKeeperResult.getInt("skId");
                EventQueue.invokeLater(new StoreKeeperGUI(storeKeeperId));
                dispose();
            }

            throw new Exception("Incorrect email and password!!!");

        } catch (Exception ex) {
            status.setText(ex.getMessage());
        }

    }//GEN-LAST:event_loginActionPerformed

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyTyped
        status.setText("");
    }//GEN-LAST:event_emailFieldKeyTyped

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        status.setText("");
    }//GEN-LAST:event_passwordFieldKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLable;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
