package com.samasend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**

 @author SamAsEnd
 */
public class Client extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    String name;
    Socket socket;
    DataInputStream in;
    PrintStream out;
    ServerSocket serverSocket;

    public Client() throws IOException, URISyntaxException {
        String ip = "";
        File f;
        name = JOptionPane.showInputDialog(null, "Enter your name?", "Name", JOptionPane.INFORMATION_MESSAGE);
        setTitle(name);

        String options[] = {"Join Server", "Start new Server"};
        int rslt = JOptionPane.showOptionDialog(null, "Join Or New Server? ", "Server",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (rslt == JOptionPane.CLOSED_OPTION || rslt == JOptionPane.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Bye Bye");
            System.exit(0);
        } else if (rslt == 1) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Server.main(null);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }.start();
            ip = "localhost";
        } else {
            ip = JOptionPane.showInputDialog(null, "Enter the server IP?", "IP", JOptionPane.INFORMATION_MESSAGE);
        }
        socket = new Socket(ip, 21021);
        in = new DataInputStream(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        initComponents();

        send("<hr><center><i><span style='color: #076d00'>" + name + " (" + socket.getLocalAddress().getCanonicalHostName() + ")</span> just joined</i></center>");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        disp = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        disp.setEditable(false);
        disp.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(disp);

        msg.setColumns(20);
        msg.setRows(5);
        jScrollPane2.setViewportView(msg);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String txt = msg.getText();
            int length = send("<hr>"
                    + "<b>" + name + "</b>: <i>" + txt.replace('<', ' ').replace('>', ' ') + "</i>").length();
            if (length < 5) {
                msg.setText("");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        send("<hr><center><i><span style='color: #ff6d00'>" + name + "</span> just left</i></center>");
    }//GEN-LAST:event_formWindowClosed

    /**
     @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Client().setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getName(), JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane disp;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea msg;
    // End of variables declaration//GEN-END:variables

    @Override
    public synchronized void actionPerformed(ActionEvent e) {
        String send = send("_msg_");
        if (!"OK".equals(send)) {
            disp.setText(send);
        }
    }

    private synchronized String send(String data) {
        String str = "";
        out.println(data);
        try {
            str = in.readUTF();
        } catch (IOException ex) {
            str = "__ERROR__";
        }
        return str;
    }
}
