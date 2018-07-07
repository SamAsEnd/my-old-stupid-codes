package com.sam;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.PopupMenu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TriangleTest extends JFrame {

    public TriangleTest(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        add(new Plate());
        start();
    }

    private void start() {
        while (true) {
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
            System.out.println("painted");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TriangleTest("Sam As End").setVisible(true);
            }
        });
    }

    private static class Plate extends JPanel {

        public Plate() {
        }

        private static int randValue() {
            double random = Math.random();
            random *= 255;
            return (int) random;
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            setBackground(Color.WHITE);
            int[] Xs = {10, 20, 30};
            int[] Ys = {10, 30, 20};
            int points = Xs.length;
            Polygon polygon = new Polygon(Xs, Ys, points);

            g.setColor(new Color(randValue(), randValue(), randValue()));
            g.fillPolygon(polygon);
            System.out.println("paint                       **");
        }

        @Override
        public void update(Graphics g) {
            super.update(g);
            paint(g);
        }

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g); 
            paint(g);
        }
        
        
        
    }
}
