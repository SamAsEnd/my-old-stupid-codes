/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author SamAsEnd
 */
public class Graphicsss extends JFrame implements KeyListener {

    private StringBuffer sb;

    public Graphicsss(String title) throws HeadlessException {
        super(title);
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.BLACK);
        sb = new StringBuffer("Sam As End");
        setVisible(true);
        start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Graphicsss graphicsss;
                graphicsss = new Graphicsss("Java 2D");
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ESCAPE) {
            dispose();
        } else if (keyCode == KeyEvent.VK_BACK_SPACE) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(e.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void start() {
        long time = System.nanoTime();
        while (true) {
            repaint();
            paintComponents(getGraphics());
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
            System.out.println("while (true) {");

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.BLACK);
        setForeground(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        g2d.drawString(sb.toString(), 200, 500);
        g2d.dispose();
        System.out.println("paint(Graphics g)");
    }

    @Override
    public void printComponents(Graphics g) {
        super.printComponents(g);
        paint(g);
        System.out.println("printComponents(Graphics g)");
    }
    
    
    
}
