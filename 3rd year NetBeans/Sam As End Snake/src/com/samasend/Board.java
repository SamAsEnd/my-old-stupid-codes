package com.samasend;

import static com.samasend.Snake.BLOCK_WIDTH;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import processing.core.PApplet;
import processing.core.PFont;

/**
 *
 * @author SamAsEnd
 */
public class Board extends PApplet {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        PApplet.main("com.samasend.Board");
    }
    int rows;
    int cols;
    int bgColor;
    Snake snake;
    //int x;
    int score;
    int highScore;
    private Apple apple;
    boolean gameOver;
    PFont font;
    javax.swing.Timer timer;
    boolean paused_;

    @Override
    public void setup() {
        highScore = 0;
        try {
            File file = new File(System.getProperty("user.home") + File.separator + "_snake_");
            if (file.exists()) {
                try (Scanner in = new Scanner(file)) {
                    highScore = in.nextInt();
                }
            }
        } catch (Exception ignore) {
            paused_ = true;
            ignore.printStackTrace();
        }
        font = createDefaultFont(BLOCK_WIDTH);
        size(600, 480);
        randomSeed(new Date().getTime());
        //System.out.println("setup");
        gameOver = false;
        //x = 0;
        score = 0;
        rows = width / BLOCK_WIDTH;
        cols = height / BLOCK_WIDTH;
        snake = new Snake(this);
        apple = new Apple(getRandomPoint(), this);
        //System.out.println("created spirits");
        rectMode(CORNER);
        bgColor = color(0);
        noLoop();

        if (timer != null) {
            timer.stop();
        }

        timer = new javax.swing.Timer(1_000 / 3, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redraw();
            }
        });

        timer.start();
        //System.out.println("setup fifnished\n\n");
    }

    @Override
    public void draw() {
        //System.out.println("draw()");
        if (paused_) {
            fill(255);
            //textMode(CENTER);
            text("Paused  (press R to restart)", width / 2, height / 2);
        } else if (gameOver) {
            fill(255);
            //textMode(CENTER);
            text("Game Over  (press R to restart)", width / 2, height / 2);
        } else {
            background(0);
            snake.move();
            cheakCollision();
            if (gameOver) {
                redraw();
            }
            snake.draw();
            apple.draw();
            //System.out.println(++x);
            //System.out.println("draw() finished");
        }
        fill(255);
        textFont(font);
        text("High Score: " + highScore + "\n"
                + "Score     : " + score, 50, BLOCK_WIDTH);
        textAlign(CENTER, CENTER);
    }

    @Override
    public void mousePressed() {
        paused_ = !paused_;
    }

    @Override
    public void keyPressed() {
        if ((key == CODED && keyCode == LEFT) || (key == 'a') || (key == 'A')) {
            snake.setDir(Snake.Direction.LEFT);
        } else if ((key == CODED && keyCode == RIGHT) || (key == 'd') || (key == 'D')) {
            snake.setDir(Snake.Direction.RIGHT);
        } else if ((key == CODED && keyCode == UP) || (key == 'w') || (key == 'W')) {
            snake.setDir(Snake.Direction.UP);
        } else if ((key == CODED && keyCode == DOWN) || (key == 's') || (key == 'S')) {
            snake.setDir(Snake.Direction.DOWN);
        } else if ((key == 'p') || (key == 'P')) {
            paused_ = !paused_;
        } else if ((key == 'r') || (key == 'R')) {
            if (paused_ || gameOver) {
                setup();
                paused_ = gameOver = false;
            }
        }
        redraw();
    }

    private Point getRandomPoint() {
        Point p;
        do {
            p = new Point((int) random(rows), (int) random(cols));
            //System.out.println(p.x + "  " + p.y);
        } while (snake.isAt(p));
        //System.out.println("x: "+p.x+"      y: "+p.y);
        return p;
    }

    private void cheakCollision() {
        LinkedList<Point> body = snake.getBody();
        for (Point point : body) {
            /*if (point.x >= rows || point.x < 0
             || point.y >= cols || point.y < 0) {
             gameOver = true;
             try {
             File file = new File(System.getProperty("user.home") + File.separator + "_snake_");
             System.out.println("");
             file.createNewFile();
             try (PrintStream out = new PrintStream(file)) {
             out.println(highScore);
             }
             } catch (Exception ignore) {
             paused_ = true;
             ignore.printStackTrace();
             }
             }*/
        }

        // eat
        if (snake.isAt(apple.getPoint())) {
            apple = new Apple(getRandomPoint(), this);
            snake.grow();
            score++;
            if (score > highScore) {
                highScore = score;
            }
            timer.setDelay(timer.getDelay() - (int) (timer.getDelay() * 0.05));
            System.out.println(timer.getDelay());
        }
    }

    public boolean isPaused_() {
        return paused_;
    }

    public void setPaused_(boolean paused_) {
        this.paused_ = paused_;
    }
}
