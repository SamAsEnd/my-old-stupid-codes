/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SamAsEnd
 */
public class GameEngine {

    static int x = 200;
    
    private void excuteEvent() {
        System.out.println("excuteEvent");
        if(gameCanvas.isPressed(KeyEvent.VK_ESCAPE)) {
            System.exit(0);
        }
        else if(gameCanvas.isPressed(KeyEvent.VK_RIGHT)) {
            x++;
        }
        else if(gameCanvas.isPressed(KeyEvent.VK_LEFT)) {
            x--;
        }
        else {
            System.out.println("no event");
        }
        
    }

    private void updateState() {
         System.out.println("updateState");
    }

    private void repaint() {
        System.out.println("repaint");
        gameWindow.repaint();
    }

    public static void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.drawString("Samson Endale", x, (int) (Math.random()*768));
    }

    private GameWindow gameWindow;
    private GameCanvas gameCanvas;

    private static final long FPS = 60;
    private static final long OneSecInNano = 1_000_000;
    private static final long OneSecInMili = 1_000;
    
    public GameEngine() {
        gameWindow = new GameWindow();
        gameCanvas = new GameCanvas();
        gameCanvas.setFocusable(true);
        gameWindow.add(gameCanvas);
        gameWindow.setVisible(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                long nanoTime = 0;
                long timeTake = 0;
                long sleepTime = 0;
                
                while (true) {
                    nanoTime = System.nanoTime();
                    gameLoop();
                    timeTake = System.nanoTime() - nanoTime;
                    sleepTime = ((OneSecInNano/FPS) - timeTake) / 1_000;
                    if(sleepTime < 10) {
                        sleepTime = 10;
                    }
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException ex) { }
                    System.out.println("sleepTime: "+sleepTime);
                }
            }
        });
    }
    
    public void gameLoop() {
        excuteEvent();
        updateState();
        repaint();
    }
}
