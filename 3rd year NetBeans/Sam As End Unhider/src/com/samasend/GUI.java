/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author SamAsEnd
 */
public class GUI extends javax.swing.JFrame {

    private HashMap<String, File> hashMap;
    private static TreeSet<String> blackList;

    public GUI() {
        initComponents();
        setVisible(true);
        hashMap = new HashMap<String, File>();
        blackList = new TreeSet<String>();
        blackList.addAll(Arrays.asList(
                "autorun.inf",
                "bootmgr",
                "System Volume Information",
                "Recovery",
                "Boot",
                "ProgramData",
                "Program Files",
                "Users",
                "Windows",
                "$Recycle.Bin",
                "pagefile.sys",
                "MSDOS.SYS",
                "IO.SYS",
                "hiberfil.sys",
                "config.sys",
                "autoexec.bat"));
        startLoading();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        drives = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hidden = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        unhide = new javax.swing.JButton();
        hide = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        shown = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exit = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        help = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sam As End");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/samasend/SamAsEnd.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        drives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drivesActionPerformed(evt);
            }
        });

        jLabel2.setText("Select the drive");

        hidden.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        hidden.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "choose the drive", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(hidden);

        jLabel3.setText("Hidden files");

        unhide.setText("Unhide");
        unhide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unhideActionPerformed(evt);
            }
        });

        hide.setText("Hide");
        hide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideActionPerformed(evt);
            }
        });

        shown.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        shown.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "choose the drive", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(shown);

        jLabel4.setText("Shown files");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(drives, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unhide, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(104, 104, 104)))
                .addComponent(hide, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(drives, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unhide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        fileMenu.setText("File");

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.ALT_MASK));
        exit.setText("Exit");
        fileMenu.add(exit);

        menuBar.add(fileMenu);

        helpMenu.setText("Help");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        helpMenu.add(about);

        help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        helpMenu.add(help);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drivesActionPerformed
        driveUpdated();
    }//GEN-LAST:event_drivesActionPerformed

    private void unhideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unhideActionPerformed
        List s = hidden.getSelectedValuesList();
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select from Hidden files", "Error", JOptionPane.WARNING_MESSAGE);
        }
        for (Object object : s) {
            try {
                String s1 = (String) object;
                if ("SAE_unknownName".equals(s1)) {
                    s1 = "" + ' ';
                }
                File file = new File((String) drives.getSelectedItem(), s1);
                if (!file.exists()) {
                    file = new File((String) drives.getSelectedItem(), "SAE_unknownName");
                }
                file.setReadable(true);
                file.setWritable(true);
                Files.setAttribute(file.toPath(), "dos:hidden", false);
                Files.setAttribute(file.toPath(), "dos:system", false);
                if (("" + ' ' + "").equals(s1)) {
                    file.renameTo(new File(file.getParentFile(), "SAE_unknownName"));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        driveUpdated();
    }//GEN-LAST:event_unhideActionPerformed

    private void hideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideActionPerformed
        List s = shown.getSelectedValuesList();
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Select from Shown files", "Error", JOptionPane.WARNING_MESSAGE);
        }
        for (Object object : s) {
            try {
                String s1 = (String) object;
                File file = new File((String) drives.getSelectedItem(), s1);
                file.setReadable(true);
                file.setWritable(true);
                Files.setAttribute(file.toPath(), "dos:hidden", true);
                Files.setAttribute(file.toPath(), "dos:system", false);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        driveUpdated();
    }//GEN-LAST:event_hideActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        JOptionPane.showMessageDialog(this, "find ur way out\nha ha ha . . . ", "Help", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_helpActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        StringBuilder builder = new StringBuilder();
        for (String string : blackList) {
            builder.append(string).append("\n");
        }
        JOptionPane.showMessageDialog(this, "For the sake of windows this files {\n" + builder.toString() + "\n} can't be touched", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutActionPerformed

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
        } catch (Exception ex) {
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JComboBox drives;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem help;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JList hidden;
    private javax.swing.JButton hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JList shown;
    private javax.swing.JButton unhide;
    // End of variables declaration//GEN-END:variables

    private void startLoading() {
        String t = ".";
        File file = new File(t);
        Iterable<Path> rootDirectories = file.toPath().getFileSystem().getRootDirectories();

        for (Path path : rootDirectories) {
            hashMap.put(path.toString(), path.toFile());
        }
        Set<String> k = hashMap.keySet();
        TreeSet<String> keys = new TreeSet<String>(k);
        drives.setModel(new DefaultComboBoxModel(keys.toArray(new String[0])));
    }

    private void driveUpdated() {
        String selectedItem = (String) drives.getSelectedItem();
        final File get = hashMap.get(selectedItem);
        if (get == null || !get.exists()) {
            JOptionPane.showMessageDialog(null, "Invalid Driver", "Error", JOptionPane.ERROR_MESSAGE);
            String[] str = {"choose other drive!!"};
            JList<String> list = new JList<String>(str);
            hidden.setModel(list.getModel());
            shown.setModel(list.getModel());
            startLoading();
            return;
        }

        hidden.setModel(new AbstractListModel() {
            String[] item = get.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File file = new File(dir, name);
                    return (!blackList.contains(name) && file.isHidden());
                }
            });

            @Override
            public int getSize() {
                return item.length;
            }

            @Override
            public Object getElementAt(int index) {
                if (item[index].equals("" + ' ') && item[index].length() <= 2) {
                    return "SAE_unknownName";
                }
                return "" + item[index] + "";
            }
        });

        shown.setModel(new AbstractListModel() {
            String[] item = get.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File file = new File(dir, name);
                    return (!blackList.contains(name) && !file.isHidden());
                }
            });

            @Override
            public int getSize() {
                return item.length;
            }

            @Override
            public Object getElementAt(int index) {
                return "" + item[index] + "";
            }
        });
    }
}
