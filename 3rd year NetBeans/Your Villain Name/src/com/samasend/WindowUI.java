package com.samasend;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * The main window
 *
 * @author SamAsEnd
 */
public class WindowUI extends javax.swing.JFrame {

    private static HashMap<Character, String> firstMap;
    private static HashMap<Character, String> secondMap;

    public WindowUI() {
        firstMap = new HashMap<>();
        getFirst();
        secondMap = new HashMap<>();
        getSecond();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        play(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        secondName = new javax.swing.JTextField();
        check = new javax.swing.JButton();
        txt = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Your Villain Name");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(getMaCursor());
        setLocationByPlatform(true);
        setResizable(false);

        plate.setBackground(new java.awt.Color(0, 0, 0));
        plate.setToolTipText(null);
        plate.setCursor(getMaCursor());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/samasend/pic.png"))); // NOI18N
        jLabel1.setToolTipText(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/samasend/villain.png"))); // NOI18N
        jLabel2.setToolTipText(null);

        firstName.setBackground(new java.awt.Color(0, 0, 0));
        firstName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        firstName.setForeground(new java.awt.Color(204, 204, 204));
        firstName.setToolTipText(null);
        firstName.setCaretColor(new java.awt.Color(255, 255, 255));
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });
        firstName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                firstNameCaretPositionChanged(evt);
            }
        });

        secondName.setBackground(new java.awt.Color(0, 0, 0));
        secondName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        secondName.setForeground(new java.awt.Color(204, 204, 204));
        secondName.setToolTipText(null);
        secondName.setCaretColor(new java.awt.Color(255, 255, 255));
        secondName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                secondNameCaretUpdate(evt);
            }
        });
        secondName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondNameActionPerformed(evt);
            }
        });

        check.setBackground(new java.awt.Color(0, 0, 0));
        check.setForeground(new java.awt.Color(204, 204, 204));
        check.setText("Check");
        check.setToolTipText(null);
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        txt.setFont(new java.awt.Font("Segoe Script", 1, 24)); // NOI18N
        txt.setForeground(new java.awt.Color(204, 204, 204));
        txt.setToolTipText(null);

        error.setBackground(new java.awt.Color(0, 0, 0));
        error.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("                              ");
        error.setToolTipText(null);

        javax.swing.GroupLayout plateLayout = new javax.swing.GroupLayout(plate);
        plate.setLayout(plateLayout);
        plateLayout.setHorizontalGroup(
            plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plateLayout.createSequentialGroup()
                .addGroup(plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(plateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plateLayout.createSequentialGroup()
                                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(secondName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        plateLayout.setVerticalGroup(
            plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plateLayout.createSequentialGroup()
                .addGroup(plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(plateLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(plateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(firstName)
                                .addComponent(secondName, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                            .addComponent(check, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(310, 310, 310)
                        .addComponent(error))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(plate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        doItBaby();
    }//GEN-LAST:event_checkActionPerformed

    private void firstNameCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_firstNameCaretPositionChanged
        error();
    }//GEN-LAST:event_firstNameCaretPositionChanged

    private void secondNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_secondNameCaretUpdate
        error();
    }//GEN-LAST:event_secondNameCaretUpdate

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        doItBaby();
    }//GEN-LAST:event_firstNameActionPerformed

    private void secondNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondNameActionPerformed
        doItBaby();
    }//GEN-LAST:event_secondNameActionPerformed

    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton check;
    private javax.swing.JLabel error;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel plate;
    private javax.swing.JTextField secondName;
    private javax.swing.JLabel txt;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="init">
    private void getFirst() {
        firstMap.put(new Character('A'), "The Evil");
        firstMap.put(new Character('B'), "The Mad");
        firstMap.put(new Character('C'), "The Big");
        firstMap.put(new Character('D'), "The Dangerous");
        firstMap.put(new Character('E'), "Captain");
        firstMap.put(new Character('F'), "The Ghostly");
        firstMap.put(new Character('G'), "Professor");
        firstMap.put(new Character('H'), "Docter");
        firstMap.put(new Character('I'), "Phantom");
        firstMap.put(new Character('J'), "The Brutal");
        firstMap.put(new Character('K'), "The Unstoppable");
        firstMap.put(new Character('L'), "The Vile");
        firstMap.put(new Character('M'), "The Dark");
        firstMap.put(new Character('N'), "The Crazy");
        firstMap.put(new Character('O'), "The Iron");
        firstMap.put(new Character('P'), "The Poison");
        firstMap.put(new Character('Q'), "The Brutal");
        firstMap.put(new Character('R'), "The Bloody");
        firstMap.put(new Character('S'), "The Dark");
        firstMap.put(new Character('T'), "The Dangerous");
        firstMap.put(new Character('U'), "The Rancid");
        firstMap.put(new Character('V'), "The Invisible");
        firstMap.put(new Character('W'), "The Black");
        firstMap.put(new Character('X'), "The Atomic");
        firstMap.put(new Character('Y'), "The Mega");
        firstMap.put(new Character('Z'), "The Grand");
    }

    private void getSecond() {
        secondMap.put(new Character('A'), "Shadow");
        secondMap.put(new Character('B'), "Knight");
        secondMap.put(new Character('C'), "Tarantula");
        secondMap.put(new Character('D'), "Skull");
        secondMap.put(new Character('E'), "MasterMind");
        secondMap.put(new Character('F'), "Wizard");
        secondMap.put(new Character('G'), "Ninja");
        secondMap.put(new Character('H'), "Devil");
        secondMap.put(new Character('I'), "Freak");
        secondMap.put(new Character('J'), "Beast");
        secondMap.put(new Character('K'), "Criminal");
        secondMap.put(new Character('L'), "Master");
        secondMap.put(new Character('M'), "Lord");
        secondMap.put(new Character('N'), "Child");
        secondMap.put(new Character('O'), "Corpse");
        secondMap.put(new Character('P'), "Slayer");
        secondMap.put(new Character('Q'), "Spider");
        secondMap.put(new Character('R'), "Creature");
        secondMap.put(new Character('S'), "Werewolf");
        secondMap.put(new Character('T'), "Monster");
        secondMap.put(new Character('U'), "Vampire");
        secondMap.put(new Character('V'), "Mutant");
        secondMap.put(new Character('W'), "Robot");
        secondMap.put(new Character('X'), "Claw");
        secondMap.put(new Character('Y'), "Machine");
        secondMap.put(new Character('Z'), "Clown");
    }
    //</editor-fold>

    private void error(String string) {
        txt.setText("");
        error.setForeground(new Color(200, 0, 0));
        error.setText(string);
    }

    private void error() {
        txt.setText("");
        error.setForeground(new Color(0, 200, 0));
        error.setText("Developed by SamAsEnd");
    }

    private void doItBaby() {
        char fChar, sChar;
        if (firstName.getText().length() < 3) {
            error("First name must be at list 3 character!!");
            return;
        }
        if (secondName.getText().length() < 3) {
            error("Second name must be at list 3 character!!");
            return;
        }
        try {
            fChar = firstName.getText().toUpperCase().charAt(0);
        } catch (Exception e) {
            error(e.getMessage());
            return;
        }
        try {
            sChar = secondName.getText().toUpperCase().charAt(0);
        } catch (Exception e) {
            error(e.getMessage());
            return;
        }
        if (!Character.isLetter(fChar)) {
            error("'" + fChar + "'" + " not a character!!");
            return;
        }
        if (!Character.isLetter(sChar)) {
            error("'" + sChar + "'" + " not a character!!");
            return;
        }
        error();
        StringBuilder sb = new StringBuilder();
        sb.append(firstMap.get(new Character(fChar))).append(" ").append(secondMap.get(new Character(sChar)));
        txt.setText(sb.toString());
    }

    Cursor getMaCursor() {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(getClass().getResource("s.png"));
        } catch (IOException iOException) {
        }
        Cursor cursor = Toolkit.getDefaultToolkit().
                createCustomCursor(bi, new Point(0, 0), null);
        return cursor;
    }

    public void play(int index) {
        InputStream sound = null;
        AudioStream audio;
        File f;
        try {
            if (index == 0) {
                sound = getClass().getResourceAsStream("x.wav");
                //sound = new FileInputStream(new File("C:\\Users\\Sam As End\\Documents\\NetBeansProjects\\Tempreture Converter\\src\\audio\\error.wav"));
            } else if (index == 1) {
                sound = getClass().getResourceAsStream("drip.au");
            } else if (index == 2) {
                sound = getClass().getResourceAsStream("computer.au");
            } else if (index == 10) {
                sound = getClass().getResourceAsStream("0.au");
            } else if (index == 11) {
                sound = getClass().getResourceAsStream("1.au");
            } else if (index == 12) {
                sound = getClass().getResourceAsStream("2.au");
            } else if (index == 13) {
                sound = getClass().getResourceAsStream("3.au");
            } else if (index == 14) {
                sound = getClass().getResourceAsStream("4.au");
            } else if (index == 15) {
                sound = getClass().getResourceAsStream("5.au");
            } else if (index == 16) {
                sound = getClass().getResourceAsStream("6.au");
            } else if (index == 17) {
                sound = getClass().getResourceAsStream("7.au");
            } else if (index == 18) {
                sound = getClass().getResourceAsStream("8.au");
            } else if (index == 19) {
                sound = getClass().getResourceAsStream("9.au");
            } else if (index == -1) {
                sound = getClass().getResourceAsStream("exit.wav");
            } else {
                return;
            }
            audio = new AudioStream(sound);
            AudioPlayer.player.start(audio);
        } catch (Exception ex) {
        }
    }
}
