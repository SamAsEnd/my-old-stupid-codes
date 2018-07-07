package com.samasend;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import processing.core.PImage;

/**
 *
 * @author SamAsEnd
 */
public class Snake {

    /**
     * The value of the default snake block<br>
     * (<b>width</b> & <b>height</b>)
     */
    public static final int BLOCK_WIDTH = 20;

    /**
     * The LinkedList store the points
     */
    private LinkedList<Point> body;

    /**
     * used to make grow the snake don't be scared it won't bit :) lol
     */
    private boolean ate;
    private Direction dir;
    private int snakeBodyColor;
    private int snakeHeadColor;
    private Board b;

    private PImage snakeImage;

    public Snake(Board b) {
        this.b = b;
        this.body = new LinkedList<>();
        body.add(new Point(b.rows / 2, b.cols / 2 + 1));
        body.add(new Point(b.rows / 2 - 1, b.cols / 2 + 1));
        body.add(new Point(b.rows / 2 - 2, b.cols / 2 + 1));
        this.ate = false;
        this.dir = Direction.RIGHT;
        this.snakeBodyColor = b.color(0, 150, 0);
        this.snakeHeadColor = b.color(0, 255, 0);
        try {
            snakeImage = new PImage(
                    ImageIO.read(
                            getClass().getResourceAsStream("/com/samasend/data/snake.png")
                    ).getScaledInstance(BLOCK_WIDTH, BLOCK_WIDTH, Image.SCALE_FAST)
            );
        } catch (IOException ex) {
            snakeImage = new PImage(BLOCK_WIDTH, BLOCK_WIDTH);
            for (int i = 0; i < snakeImage.width; i++) {
                for (int j = 0; j < snakeImage.height; j++) {
                    snakeImage.set(i, j, b.color(0, 255, 0));
                }
            }
        }
    }

    void move() {
        if (dir == Direction.UP) {
            moveUp();
        } else if (dir == Direction.DOWN) {
            moveDown();
        } else if (dir == Direction.LEFT) {
            moveLeft();
        } else {   //if (dir == Direction.RIGHT)
            moveRight();
        }
    }

    void moveUp() {
        Point head = body.peekFirst();
        Point newHead = new Point(head);
        newHead.y--;
        if (newHead.y < 0) {
            newHead.y = b.cols - 1;
        }
        if (body.contains(newHead)) {
            b.gameOver = true;
        } else {
            body.addFirst(newHead);
            Point tail = body.pollLast();
            ifAte(tail);
        }
    }

    void moveRight() {
        Point head = body.peekFirst();
        Point newHead = new Point(head);
        newHead.x++;
        if (newHead.x > b.rows - 1) {
            newHead.x = 0;
        }
        if (body.contains(newHead)) {
            b.gameOver = true;
        } else {
            body.addFirst(newHead);
            Point tail = body.pollLast();
            ifAte(tail);
        }
    }

    void moveDown() {
        Point head = body.peekFirst();
        Point newHead = new Point(head);
        newHead.y++;
        if (newHead.y > b.cols - 1) {
            newHead.y = 0;
        }
        if (body.contains(newHead)) {
            b.gameOver = true;
        } else {
            body.addFirst(newHead);
            Point tail = body.pollLast();
            ifAte(tail);
        }
    }

    void moveLeft() {
        Point head = body.peekFirst();
        Point newHead = new Point(head);
        newHead.x--;
        if (newHead.x < 0) {
            newHead.x = b.rows - 1;
        }
        if (body.contains(newHead)) {
            b.gameOver = true;
        } else {
            body.addFirst(newHead);
            Point tail = body.pollLast();
            ifAte(tail);
        }
    }

    private void ifAte(Point tail) {
        if (ate) {
            body.addLast(tail);
            ate = false;
        }
    }

    boolean isAt(Point p) {
        return body.contains(p);
    }

    void grow() {
        ate = true;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public void draw() {
        b.rectMode(Board.CORNER);
        for (Point point : body) {
            if (point.equals(body.peekFirst())) {
                b.fill(snakeHeadColor);
                b.rect(point.x * BLOCK_WIDTH, point.y * BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
            } else {
                b.fill(snakeBodyColor);
                //      points
                //b.rect(point.x * BLOCK_WIDTH, point.y * BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);

                //      images
                b.imageMode(b.CORNER);
                b.image(snakeImage, point.x * BLOCK_WIDTH, point.y * BLOCK_WIDTH, BLOCK_WIDTH, BLOCK_WIDTH);
            }
        }

    }

    public boolean isAte() {
        return ate;
    }

    public void setAte(boolean ate) {
        this.ate = ate;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        if (!b.isPaused_()) {
            if (!oppositeDir(dir)) {
                this.dir = dir;
            }
        }
    }

    public int getSnakeBodyColor() {
        return snakeBodyColor;
    }

    public void setSnakeBodyColor(int snakeBodyColor) {
        this.snakeBodyColor = snakeBodyColor;
    }

    public int getSnakeHeadColor() {
        return snakeHeadColor;
    }

    public void setSnakeHeadColor(int snakeHeadColor) {
        this.snakeHeadColor = snakeHeadColor;
    }

    public Board getB() {
        return b;
    }

    public void setB(Board b) {
        this.b = b;
    }

    private boolean oppositeDir(Direction dir) {
        return (dir == Direction.DOWN && this.dir == Direction.UP
                || dir == Direction.UP && this.dir == Direction.DOWN
                || dir == Direction.LEFT && this.dir == Direction.RIGHT
                || dir == Direction.RIGHT && this.dir == Direction.LEFT);
    }

    enum Direction {

        UP, RIGHT, DOWN, LEFT
    };
}
