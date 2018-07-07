/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Sam As End
 */
public class Main extends JFrame {

    private static final long FPS = 30;
    private static final long TIME = 1_000 / FPS;

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        super("Sam As End 2D");
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyControl());
        addMouseListener(new MouseControl());
        setBackground(Color.BLACK);
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameLoop();
            }
        });
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        draw(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public void GameLoop() {
        long start, end, diff;
        while (true) {
            if(KeyControl.isPressed(KeyEvent.VK_ESCAPE)){
                dispose();
            }
            else {
                System.out.println("dsfsd sd fsdf ");
                S
            }
            start = System.nanoTime() / 1_000;
            //repaint();
            draw(getGraphics());
            end = System.nanoTime() / 1_000;
            diff = end - start;
            diff = TIME - diff;
            if (diff < 100) {
                diff = 100;
            }
            try {
                //System.out.println("Sleep for "+diff);
                Thread.sleep(diff);
            } catch (InterruptedException ex) {
            }
        }
    }
    private int x;
    private int y;
    private int oldX;
    private int oldY;

    private void draw(Graphics gg) {
        Graphics2D g = (Graphics2D) gg;
        
    }
}
