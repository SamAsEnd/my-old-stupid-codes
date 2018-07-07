/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author SamAsEnd
 */
public class GameCanvas extends JPanel implements KeyListener {

    public GameCanvas() {
        key = new boolean[512];
    }
    
    //<editor-fold defaultstate="collapsed" desc="Key">
    private boolean[] key;
    
    public boolean isPressed(int code) {
        return key[code];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        key[e.getKeyCode()] = true;
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        key[e.getKeyCode()] = false;
    }

    //</editor-fold>
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        GameEngine.paint((Graphics2D) g);
    }
    
}
