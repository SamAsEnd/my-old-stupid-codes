/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author SamAsEnd
 */
public class GUI extends javax.swing.JFrame {

    private File f;
    int count = 0;

    public GUI() {
        try {
            String temp = System.getProperty("user.home");
            f = new File(temp, "_DON'T_DELETE_");
            if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(getF()));
                String strNum = br.readLine();
                br.close();
                count = Integer.parseInt(strNum);
            } else {
                f.createNewFile();
            }
            count++;
            BufferedWriter bw = new BufferedWriter(new FileWriter(getF()));
            bw.write(""+count);
            bw.close();
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException.toString(), iOException.getMessage(), JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Reset to 0\n" + numberFormatException.toString(), numberFormatException.getMessage(), JOptionPane.ERROR_MESSAGE);
            count++;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(getF()))) {
                bw.write(""+count);
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.toString(), iOException.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lable = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lable.setFont(new java.awt.Font("LCD", 1, 48)); // NOI18N
        lable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lable.setText("Count = "+count);

        reset.setFont(new java.awt.Font("LCD", 0, 24)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        close.setFont(new java.awt.Font("LCD", 0, 24)); // NOI18N
        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lable, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(close)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        try {
            count = 0;
            lable.setText("Count = " + count);
            BufferedWriter bw = new BufferedWriter(new FileWriter(getF()));
            bw.write(""+count);
            bw.close();
        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException.toString(), iOException.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_resetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel lable;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the f
     */
    public File getF() {
        return f;
    }

    /**
     * @param f the f to set
     */
    public void setF(File f) {
        this.f = f;
    }
}
