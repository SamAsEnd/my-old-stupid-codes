package samasend.domwload.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sun.awt.windows.ThemeReader;

public class Interface extends javax.swing.JFrame {

    public Interface() {
        initComponents();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                //if ("Nimbus".equals(info.getName())) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add = new javax.swing.JButton();
        bar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        add.setText("Add  URL");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(add)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        String urlString = JOptionPane.showInputDialog(this, null, "Enter the URL", JOptionPane.QUESTION_MESSAGE);
        // lazy thing 
        urlString = "http://localhost/equilibrium.mkv";
        //urlString = "http://localhost/index.php";


        final URL url;
        String fileString;
        File tempFile;
        final BufferedWriter writer;
        final BufferedReader reader;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(this, null, "MalformedURLException", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("URL constracted");
        fileString = url.getFile();
        if ("".equals(fileString) || fileString == null) {
            JOptionPane.showMessageDialog(this, null, "No file on the url", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("file found on the URL");
        try {
            tempFile = File.createTempFile(fileString, ".tmp");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, null, "Couldn't creat temp file", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("createed Temp File");
        try {
            writer = new BufferedWriter(new FileWriter(tempFile));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, null, "Couldn't write to temp file", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("BufferedWriter");
        try {
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, null, "Couldn't read from url", JOptionPane.ERROR_MESSAGE);
            return;
        }
        System.out.println("BufferedReader");


        Runnable runnable;
        runnable = new Runnable() {
            public void run() {
                long length;
                long i = 0;

                try {
                    length = url.openConnection().getContentLength();
                    System.out.println("length: " + length);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, null, "Exception while reading length", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                char buff[] = new char[1024 * 1024];
                try {
                    long n = 0;
                    long startTime = System.nanoTime();
                    long nanoTime = System.nanoTime();
                    long lastUpdate = nanoTime;
                    while ((n = (reader.read(buff))) != -1) {
                        writer.write(buff);
                        i += n;
                        long proI = (i * 100) / length;
                        long timeL = System.nanoTime() - nanoTime;
                        //time *= 1_000_000;
                        double speedD = ((n * 2) * 1_000_000) / timeL;
                        bar.setValue((int) Math.abs(proI));
                        System.out.println("i = " + i);
                        System.out.println("n = " + n);
                        nanoTime = System.nanoTime();
                        if( nanoTime - lastUpdate > 500_000) {
                            jLabel1.setText(goodPrint(speedD));
                            lastUpdate = System.nanoTime();
                        }
                        System.out.println("speed = " + speedD);
                        System.out.println("pro = " + proI + "%");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                        //timeL = System.nanoTime() - nanoTime;
                        
                        //speedD = ((i*2) * 1_000_000 ) / timeL;
                        
                        nanoTime = System.nanoTime();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, null, "Error while reading/writing", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            private String goodPrint(double speedD) {
                if(speedD <= 0) 
                    return "No transfer";
                else if(speedD > 1_024 * 1_024 * 1_024) {
                    speedD = speedD / 1_024 * 1_024 * 1_024;
                    return (float)speedD + " Gb/s";
                }
                else if(speedD > 1_024 * 1_024) {
                    speedD = speedD / 1_024 * 1_024;
                    return (float)speedD + " Mb/s";
                }
                else if(speedD > 1_024) {
                    speedD = speedD / 1_024;
                    return (float)speedD + " Kb/s";
                }
                return (float)speedD + " byte/s";
            }
        };
        new Thread(runnable).start();
        JOptionPane.showMessageDialog(this, null, "Done", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_addActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JProgressBar bar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
