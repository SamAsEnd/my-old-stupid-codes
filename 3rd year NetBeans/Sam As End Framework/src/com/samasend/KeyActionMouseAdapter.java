package com.samasend;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.PriorityQueue;
import javax.swing.JFrame;

/**
 *
 * @author SamAsEnd
 */
class KeyActionMouseAdapter implements KeyActionMouseListener {

    //<editor-fold defaultstate="collapsed" desc="constracter">
    public KeyActionMouseAdapter(JFrame frame) {
        key = new PriorityQueue<>();
        keyPress = new boolean[1024];
        mouse = new PriorityQueue<>();
        this.frame = frame;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Key">
    private PriorityQueue<KeyEvent> key;
    private boolean[] keyPress;

    public boolean isPressed(int key) {
        return this.keyPress[key];
    }

    public PriorityQueue<KeyEvent> getKey() {
        return key;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        key.offer(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPress[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPress[e.getKeyCode()] = false;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="mouse">
    private PriorityQueue<MouseEvent> mouse;

    @Override
    public void mouseClicked(MouseEvent e) {
        mouse.offer(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouse.offer(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouse.offer(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouse.offer(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouse.offer(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouse.offer(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse.offer(e);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="action">
    private JFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
    //</editor-fold>
}
