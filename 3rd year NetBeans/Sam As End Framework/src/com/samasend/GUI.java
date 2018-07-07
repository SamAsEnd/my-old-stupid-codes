package com.samasend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class GUI extends JFrame{

    public GUI(String title) throws HeadlessException {
        super(title);
        init();
    }

    private void init() {
        setFullScreen();
        //setWindowMode(800, 600);
        setBackground(Color.BLACK);
        p = new Point(0, 0);
    }

    private void setFullScreen() {
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
    }

    private void setWindowMode(int width,int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw((Graphics2D)g);
    }

    Point p;
    int direction;
    private void draw(Graphics2D g2d) {
        BufferedImage bi = new BufferedImage(1366, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setBackground(Color.black);
        g.setColor(Color.black);
        g.fillRect(0, 0, 1366, 768);
        if(direction == 0) {
            //left
            p.x++;
            if((p.x + 50) >= 1366) {
                direction++;
            }
        }
        else if(direction == 1) {
            //down
            p.y++;
            if((p.y + 50) >= 768) {
                direction++;
            }
        }
        else if(direction == 2) {
            //right
            p.x--;
            if((p.x) <= 0) {
                direction++;
            }
        }
        else if(direction == 3) {
            //up
            p.y--;
            if((p.y) <= 0) {
                direction++;
            }
        }
        else {
            direction = 0;
            draw(g);
            return;
        }
        g.setBackground(Color.red);
        g.setColor(Color.black);
        g.fillRect(p.x, p.y, 50, 50);
        
        // paint the buff
        g2d.drawImage(bi, 0 , 0, null);
    }        
   
}
