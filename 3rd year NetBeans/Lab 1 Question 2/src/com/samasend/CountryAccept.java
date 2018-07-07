package com.samasend;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author Sam As End
 */
public class CountryAccept extends javax.swing.JDialog {

    private final Country country;

    public CountryAccept(java.awt.Frame parent, boolean modal, Country country) {
        super(parent, modal);
        this.country = country;
        initComponents();
        countryName.setText(country.getName());
        String name = country.getName();
        URL url = getClass().getResource("/com/samasend/flag/" + name + ".png");
        countryName.setIcon(
                new ImageIcon(url)
        );
        FocusListener focusListener = new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent event) {
                try {
                    JTextField field = (JTextField) event.getSource();
                    field.setBackground(Color.WHITE);
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }

            @Override
            public void focusLost(FocusEvent event) {
                JTextField field = null;
                try {
                    field = (JTextField) event.getSource();
                    int i = Integer.parseInt(field.getText());
                    if (i > 100 || i < 0) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    if (field != null) {
                        field.setBackground(new Color(255, 155, 155));
                    }
                }
            }
        };
        
        JTextField[] fields = {ap,gdp,gr,pg,rf};
        
        for (JTextField field : fields) {
            field.addFocusListener(focusListener);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        inputPanel = new javax.swing.JPanel();
        pg = new javax.swing.JTextField();
        gdp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ap = new javax.swing.JTextField();
        rf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gr = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        countryName = new javax.swing.JLabel();
        pass = new javax.swing.JButton();
        pass1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        main.setBackground(new java.awt.Color(255, 255, 255));
        main.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  አምስቱ የትንበያ መርሖች አስገባ  ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Visual Geez Unicode", 0, 24), new java.awt.Color(67, 67, 67))); // NOI18N
        main.setForeground(new java.awt.Color(78, 78, 78));

        inputPanel.setBackground(new java.awt.Color(255, 255, 255));
        inputPanel.setForeground(new java.awt.Color(78, 78, 78));

        pg.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        pg.setForeground(new java.awt.Color(67, 67, 67));
        pg.setToolTipText("");

        gdp.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        gdp.setForeground(new java.awt.Color(67, 67, 67));
        gdp.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(67, 67, 67));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("የእድገት ደረጃ");

        jLabel3.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(67, 67, 67));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("የዝናብ መጠን");

        ap.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        ap.setForeground(new java.awt.Color(67, 67, 67));
        ap.setToolTipText("");

        rf.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        rf.setForeground(new java.awt.Color(67, 67, 67));
        rf.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(67, 67, 67));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("የፖለቲካ እድገት");

        jLabel8.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(67, 67, 67));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("የዓመቱ የሰብል ምርት መጠን");

        gr.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        gr.setForeground(new java.awt.Color(67, 67, 67));
        gr.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Visual Geez Unicode", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(67, 67, 67));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ጂዲፒ");

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(inputPanelLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(gdp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(gr, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pg, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ap, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        countryName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        countryName.setForeground(new java.awt.Color(67, 67, 67));
        countryName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pass.setFont(new java.awt.Font("Visual Geez Unicode", 0, 24)); // NOI18N
        pass.setForeground(new java.awt.Color(78, 78, 78));
        pass.setText("ይለፍ");
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        pass1.setFont(new java.awt.Font("Visual Geez Unicode", 0, 24)); // NOI18N
        pass1.setForeground(new java.awt.Color(78, 78, 78));
        pass1.setText("ዝጋ");
        pass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                        .addComponent(countryName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(countryName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        try {
            country.setAnnualProduct(Integer.parseInt(ap.getText()));
            country.setGdp(Integer.parseInt(gdp.getText()));
            country.setGrowthLevel(Integer.parseInt(gr.getText()));
            country.setPoliticalGrowth(Integer.parseInt(pg.getText()));
            country.setRainFall(Integer.parseInt(rf.getText())); 
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());//, "ERROR", JOptionPane.YES_NO_CANCEL_OPTION);
        }
    }//GEN-LAST:event_passActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        passActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void pass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure?", "Close", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_pass1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ap;
    private javax.swing.JLabel countryName;
    private javax.swing.JTextField gdp;
    private javax.swing.JTextField gr;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel main;
    private javax.swing.JButton pass;
    private javax.swing.JButton pass1;
    private javax.swing.JTextField pg;
    private javax.swing.JTextField rf;
    // End of variables declaration//GEN-END:variables
}
