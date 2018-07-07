package com.samasend;

import static java.awt.Color.WHITE;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.ImageIcon;

public class InfoDisplay extends javax.swing.JDialog {

    private Country country;

    public InfoDisplay(Frame parent, Country country) {
        super(parent, true);
        initComponents();
        getContentPane().setBackground(WHITE);
        this.country = country;
        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cuCode = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        conti = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        popu = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        am = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        en = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        capital = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cuCode.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        cuCode.setForeground(new java.awt.Color(67, 67, 67));
        cuCode.setText("XXXXXXXXXXXXXXXXXXXX");

        jLabel4.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(67, 67, 67));
        jLabel4.setText("የሀገሪቱ ኮድ");

        conti.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        conti.setForeground(new java.awt.Color(67, 67, 67));
        conti.setText("XXXXXXXXXXXXXXXXXXXX");

        jLabel9.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(67, 67, 67));
        jLabel9.setText("<html>ስፋት በ(Km)<sup>2<sup>");

        popu.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        popu.setForeground(new java.awt.Color(67, 67, 67));
        popu.setText("XXXXXXXXXXXXXXXXXXXX");

        area.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        area.setForeground(new java.awt.Color(67, 67, 67));
        area.setText("XXXXXXXXXXXXXXXXXXXX");

        am.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        am.setForeground(new java.awt.Color(67, 67, 67));
        am.setText("XXXXXXXXXXXXXXXXXXXX");

        jLabel5.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(67, 67, 67));
        jLabel5.setText("የገንዘብ ኮድ");

        en.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        en.setForeground(new java.awt.Color(67, 67, 67));
        en.setText("XXXXXXXXXXXXXXXXXXXX");

        jLabel8.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(67, 67, 67));
        jLabel8.setText("እሀጉር");

        capital.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        capital.setForeground(new java.awt.Color(67, 67, 67));
        capital.setText("XXXXXXXXXXXXXXXXXXXX");

        code.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        code.setForeground(new java.awt.Color(67, 67, 67));
        code.setText("XXXXXXXXXXXXXXXXXXXX");

        jLabel3.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(67, 67, 67));
        jLabel3.setText("ስም በእንግሊዘኛ");

        jLabel2.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(67, 67, 67));
        jLabel2.setText("ስም በአማርኛ");

        jLabel6.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(67, 67, 67));
        jLabel6.setText("የህዝብ ብዛት");

        jLabel7.setFont(new java.awt.Font("Nyala", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(67, 67, 67));
        jLabel7.setText("ዋና ከተማ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(am, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(code, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(en, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cuCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(popu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(capital, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conti, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(area, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(am))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))))
                    .addComponent(code))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(en))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cuCode)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(popu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(capital))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(conti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(area))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 180, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel am;
    private javax.swing.JLabel area;
    private javax.swing.JLabel capital;
    private javax.swing.JLabel code;
    private javax.swing.JLabel conti;
    private javax.swing.JLabel cuCode;
    private javax.swing.JLabel en;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel popu;
    // End of variables declaration//GEN-END:variables

    private void loadData() {
        code.setText(country.getCode());
        am.setText(country.getName_am());
        en.setText(country.getName_en());
        cuCode.setText(country.getCurrencyCode());
        popu.setText(groupDigit(country.getPopulation()));
        capital.setText(country.getCapital());
        conti.setText(country.getContinent());
        area.setText(groupDigit((long) country.getAreaInSqKm()));
        img.setIcon(
                new ImageIcon(
                        country.getIcon()
                        .getImage()
                        .getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
    }

    private String groupDigit(long population) {
        return new DigitGroup(population).toString();
    }

}
