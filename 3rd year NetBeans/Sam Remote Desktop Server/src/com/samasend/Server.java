package com.samasend;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Server extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private LinkedList<BufferedImage> images = new LinkedList<>();
    private LinkedList<String> msg = new LinkedList<>();
    private Socket socket = null;
    private BufferedReader reader = null;
    private PrintStream printer = null;
    private File temp;
    private BufferedImage lastImage;

    @Override
    public void run() {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //BufferedImage image = images.removeFirst();
                    Graphics g = iFrame.getContentPane().getGraphics();
                    g.drawImage(lastImage, 0, 0, 1366/2, 768/2, null);
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex.toString());
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Timer(1_000 / 60, listener).start();
            }
        }).start();

        while (true) {
            try {
                synchronized (printer) {
                    printer.println("0");
                }
                BufferedImage image = ImageIO.read(socket.getInputStream());
                //images.addLast(image);
                lastImage = image;
                try {
                    synchronized (this) {
                        wait(50);
                        notifyAll();
                    }
                } catch (InterruptedException ex) {
                }

            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    public Server() {
        try {
            JOptionPane.showMessageDialog(null, "About to Start Server . . . ", "Server info", JOptionPane.INFORMATION_MESSAGE);
            socket = new ServerSocket(21021).accept();
            String hostName = socket.getInetAddress().getCanonicalHostName();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            JOptionPane.showMessageDialog(null, hostName + " Connected", "New Client", JOptionPane.INFORMATION_MESSAGE);
            printer = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        iFrame = new javax.swing.JInternalFrame();
        sendMouse = new javax.swing.JCheckBox();
        cmd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktop.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        iFrame.setClosable(true);
        iFrame.setIconifiable(true);
        iFrame.setMaximizable(true);
        iFrame.setResizable(true);
        iFrame.setTitle("Sam As End");
        iFrame.setToolTipText("");
        iFrame.setDoubleBuffered(true);
        try {
            iFrame.setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        iFrame.setVisible(true);
        iFrame.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                iFrameMouseWheelMoved(evt);
            }
        });
        iFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                iFrameMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                iFrameMousePressed(evt);
            }
        });
        iFrame.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                iFrameMouseMoved(evt);
            }
        });
        iFrame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iFrameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iFrameKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout iFrameLayout = new javax.swing.GroupLayout(iFrame.getContentPane());
        iFrame.getContentPane().setLayout(iFrameLayout);
        iFrameLayout.setHorizontalGroup(
            iFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        iFrameLayout.setVerticalGroup(
            iFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        desktop.add(iFrame);
        iFrame.setBounds(20, 30, 430, 270);

        sendMouse.setText("Send Mouse Position");

        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sendMouse)
                .addGap(32, 32, 32)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMouse, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iFrameMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iFrameMouseMoved
        if (sendMouse.isSelected()) {
            synchronized (printer) {
                printer.println(1 + " " + evt.getX() + " " + evt.getY());
            }
        }
    }//GEN-LAST:event_iFrameMouseMoved

    private void iFrameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iFrameMousePressed
        if (sendMouse.isSelected()) {

            synchronized (printer) {
                printer.println(1 + " " + evt.getX() + " " + evt.getY());
                printer.println(7 + " " + " " + evt.getModifiersEx());
            }
        }
    }//GEN-LAST:event_iFrameMousePressed

    private void iFrameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iFrameMouseReleased
        if (sendMouse.isSelected()) {

            synchronized (printer) {
                printer.println(1 + " " + evt.getX() + " " + evt.getY());
                printer.println(3 + " " + " " + evt.getModifiersEx());
            }
        }
    }//GEN-LAST:event_iFrameMouseReleased

    private void iFrameMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_iFrameMouseWheelMoved
        if (sendMouse.isSelected()) {
            synchronized (printer) {
                printer.println(1 + " " + evt.getX() + " " + evt.getY());
                printer.println(4 + " " + evt.getScrollAmount());
            }
        }
    }//GEN-LAST:event_iFrameMouseWheelMoved

    private void iFrameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iFrameKeyPressed
        if (sendMouse.isSelected()) {
            synchronized (printer) {
                printer.println(5 + " " + evt.getKeyCode());
            }
        }
    }//GEN-LAST:event_iFrameKeyPressed

    private void iFrameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iFrameKeyReleased
        if (sendMouse.isSelected()) {
            synchronized (printer) {
                printer.println(6 + " " + evt.getKeyCode());
            }
        }
    }//GEN-LAST:event_iFrameKeyReleased

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        synchronized (printer) {
            printer.println(9 + " " + cmd.getText());
        }
    }//GEN-LAST:event_cmdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        //</editor-fold>
        Server server = new Server();
        server.setVisible(true);
        new Thread(server).start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cmd;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JInternalFrame iFrame;
    private javax.swing.JCheckBox sendMouse;
    // End of variables declaration//GEN-END:variables
}
