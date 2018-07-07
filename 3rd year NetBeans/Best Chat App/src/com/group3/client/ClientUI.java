package com.group3.client;

import com.group3.ClientCommand;
import com.group3.Command;
import com.group3.ServerCommand;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

public class ClientUI extends JFrame implements Runnable, Command {

    private static final long serialVersionUID = 21_021L;

    private final InetAddress host;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintStream out;

    private int lastMessageIndex = 0;

    public ClientUI(InetAddress host) throws IOException {
        this.host = host;
        socket = new Socket(host, 21210);
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        out = new PrintStream(
                socket.getOutputStream());
        initComponents();
        reloadUsers();
        reloadMsg();
    }

    @Override
    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                serverListener();
            }
        }).start();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code & Event Handler">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        messageScroller = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageField = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageView = new javax.swing.JEditorPane();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        sendMessageBtn = new javax.swing.JButton();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tekton Pro Cond", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Best Chat App");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        userList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        messageScroller.setViewportView(userList);

        jButton9.setText("View Desktop");

        jButton10.setText("Call");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageScroller)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageScroller)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        messageField.setColumns(20);
        messageField.setRows(5);
        jScrollPane2.setViewportView(messageField);

        jScrollPane1.setViewportView(messageView);

        jButton6.setText("Attach File");

        jButton7.setText("Attach Image");

        sendMessageBtn.setText("Send Message");
        sendMessageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sendMessageBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMessageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        status.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(status)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageBtnActionPerformed
        try {
            boolean toAll = false;
            String message = messageField.getText();
            List<String> selectedValuesList = (List<String>) userList.getSelectedValuesList();
            if (message.length() <= 0) {
                throw new Exception("Message is empty!!!");
            } else if (selectedValuesList.isEmpty()) {
                toAll = true;
            }
            out.write(ClientCommand.NEW_MESSAGE);
            if (toAll) {
                out.write(ClientCommand.PUBLIC_MESSAGE);
            } else {
                out.write(ClientCommand.PRIVATE_MESSAGE);
                for (String userName : selectedValuesList) {
                    out.println(userName);
                }
            }
            out.println(message);
            out.println(Command.EO_MESSAGE);
            reloadMsg();
        } catch (Exception e) {
            status.setText(e.getMessage());
            status.setForeground(Color.GREEN);
        }

    }//GEN-LAST:event_sendMessageBtnActionPerformed
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables">                          
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageField;
    private javax.swing.JScrollPane messageScroller;
    private javax.swing.JEditorPane messageView;
    private javax.swing.JButton sendMessageBtn;
    private javax.swing.JLabel status;
    private javax.swing.JList userList;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>

    void serverListener() {
        while (true) {
            try {
                int read = in.read();
                if (read == ServerCommand.RECIEVED_MESSAGE) {
                    reloadMsg();
                } else if (read == ServerCommand.NEW_CLIENT) {
                    reloadUsers();
                } else {
                    ;
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private synchronized void reloadMsg() {
        try {
            out.write(ClientCommand.GET_MESSAGE);
            out.write(ClientCommand.MESSAGE_INDEX);
            out.write(lastMessageIndex);
            String message = "";
            String buff;
            while ((buff = in.readLine()) == null) {
                if (buff.charAt(0) == ServerCommand.STOP_READING) {
                    lastMessageIndex = in.read();
                    break;
                }
                message += (buff + "<br />\n");
            }
            messageView.setText(messageView.getText() + "\n\n\n" + buff);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void reloadUsers() {
        try {
            out.write(ClientCommand.GET_CLIENT_LIST);
            ArrayList<String> users = new ArrayList<>(10);
            String buff;
            while ((buff = in.readLine()) == null) {
                if (buff.charAt(0) == ServerCommand.STOP_READING) {
                    break;
                }
                users.add(buff);
            }

            List<String> selectedValuesList = null;

            synchronized (userList) {
                if (!userList.isSelectionEmpty()) {
                    selectedValuesList = (List<String>) userList.getSelectedValuesList();
                }
                userList.setModel(
                        new DefaultComboBoxModel<String>(
                                new Vector<String>(users)));
                if (selectedValuesList != null && !selectedValuesList.isEmpty()) {
                    for (Object object : selectedValuesList) {
                        if (users.contains(object)) {
                            userList.setSelectedValue(object, false);
                        }
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
