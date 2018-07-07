package com.samasend;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Framework extends JFrame {
    
    public Framework() {
        setup();
        setVisible(true);
        start();
    }
    private Color fillColor = Color.BLACK;
    
    public void noFill() {
        fillColor = null;
    }
    private Color strokeColor = Color.BLACK;
    
    public void noStroke() {
        strokeColor = null;
    }
    
    public void fill(int g) {
        fillColor = getColor(g);
    }
    
    public void fill(int r, int g, int b) {
        fillColor = getColor(r, g, b);
    }
    
    public void stroke(int g) {
        strokeColor = getColor(g);
    }
    
    public void stroke(int r, int g, int b) {
        strokeColor = getColor(r, g, b);
    }
    
    private void start() {
        
        while (loop) {
            draw();
            
            try {
                
                
                wait(1000);
            } catch (InterruptedException ex) {
            }
            
        }
        
    }
    
    @Override
    public void paint(Graphics g) {
    }
    
    private void setup() {
        size(100, 100);
        noLoop();
    }
    
    private void size(int width, int height) {
        setSize(width, height);
    }
    
    //<editor-fold defaultstate="collapsed" desc="bg">
    public void background(int bgColor) {
        setBackground(getColor(bgColor));
    }
    
    public void background(int r, int g, int b) {
        setBackground(getColor(r, g, b));
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="getColor">
    private Color getColor(int grayScale) {
        return new Color(grayScale, grayScale, grayScale);
    }
    
    private Color getColor(int r, int g, int b) {
        return new Color(r, g, b);
    }
    //</editor-fold>
    
    private void draw() { 
    }
    
    //<editor-fold defaultstate="collapsed" desc="Loop">
    private boolean loop = true;
    
    private void noLoop() {
        loop = false;
    }
    //</editor-fold>
    
    private Graphics2D g;
    
    private void rect(int x, int y, int width, int height) {
        if(fillColor == null) {
            g.drawRect(x, y, width, height);
        }
        else {
            g.fillRect(x, y, width, height);
        }
    }
}
