package com.samasend;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class PhotoViewer extends javax.swing.JDialog {

    ImageIcon icon;

    public PhotoViewer(java.awt.Frame parent, ImageIcon icon) {
        super(parent,true);
        initComponents();
        getContentPane().setBackground(new Color(57,57,57));
        this.icon = icon;
        startScaling();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        display = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        val = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(57, 57, 57));

        display.setBackground(new java.awt.Color(69, 69, 69));
        display.setForeground(new java.awt.Color(47, 47, 47));
        display.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        display.setText(" ");
        display.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        slider.setBackground(new java.awt.Color(108, 108, 108));
        slider.setForeground(new java.awt.Color(204, 204, 204));
        slider.setMajorTickSpacing(50);
        slider.setMaximum(500);
        slider.setMinimum(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setToolTipText("zoom");
        slider.setValue(100);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        val.setForeground(new java.awt.Color(204, 204, 204));
        val.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(display, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(val, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        startScaling();
    }//GEN-LAST:event_sliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel display;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider slider;
    private javax.swing.JLabel val;
    // End of variables declaration//GEN-END:variables
    private void startScaling() {
        int v = slider.getValue();
        val.setText(v + " %");
        scale(v);
    }

    private void scale(int per) {
        Image image = icon.getImage();
        int w = icon.getIconWidth();
        int h = icon.getIconHeight();

        double newW = (double) w * per / 100.0;
        double newH = (double) h * per / 100.0;

        Image scaledInstance = image.getScaledInstance((int) newW, (int) newH, Image.SCALE_FAST);

        display.setIcon(new ImageIcon(scaledInstance));
        
    }

}
