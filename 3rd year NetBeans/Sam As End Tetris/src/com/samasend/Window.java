package com.samasend;

import com.samasend.shape.Shape;
import static com.samasend.shape.Shape.randomShape;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import processing.core.PApplet;

/**

 @author SamAsEnd
 */
public class Window extends PApplet {

    private static final long serialVersionUID = 1L;
    //##############################################
    private int[][] box;
    private Point point;
    private Shape currentShape;
    private Shape nextShape;
    private int score;
    private boolean gameOver;
    private boolean reNew;
    private Timer timer;
    private ActionListener al;
    int zi = 0;

    //##############################################
    @Override
    public void setup() {
        score = 0;
        gameOver = false;
        reNew = false;
        point = new Point(Constant.WINDOW_WIDTH / 2 - 1, 0);
        box = new int[Constant.WINDOW_WIDTH][Constant.WINDOW_HEIGHT];
        //new Shape is not allowed head use Shape.randomShape()
        currentShape = Shape.randomShape((int) random(0, 6));
        nextShape = Shape.randomShape((int) random(0, 6));
        //the +6 if b/c i want the right side display 
        //the score and the next Shape comin Nothing else
        size((Constant.WINDOW_WIDTH + 4) * Constant.BLOCK + 2,
                Constant.WINDOW_HEIGHT * Constant.BLOCK + 2);
        //btw if u see a method in this class 
        //start with underscore THOSE are mine NOT FROM PApplet
        _resetViewPort();
        noLoop(); // 10x i will loop it my self nigga
        al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redraw();
            }
        };
        timer = new Timer(1_000 / 2, al);
        timer.start();
    }

    @Override
    public void draw() {
        if (gameOver) {
            timer.stop();
            fill(255);
            text("Game Over", (Constant.WINDOW_WIDTH / 2 - 1) * Constant.BLOCK, 50);
        }
        _resetViewPort();
        paint_me();
        if (reNew) {
            int[][] p = currentShape.getPoints();
            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < p[i].length; j++) {
                    int xx = i + point.x;
                    int yy = j + point.y;
                    if (p[i][j] == 1) {
                        box[xx][yy] = 1;
                    }
                }
            }
            currentShape = nextShape;
            nextShape = Shape.randomShape((int) random(0, 6));
            reNew = false;
            point = new Point(Constant.WINDOW_WIDTH / 2 - 1, 0);
            timer.stop();
            timer = new Timer(1_000 / 2, al);
            timer.start();
        }
        zi++;
        move_down();
        // cheak clear
//        for (int i = box.length - 1; i >= 0; i--) {
//            boolean c = true;
//            for (int j = 0; j < box[i].length; j++) {
//                if (box[i][j] != 1) {
//                    c = false;
//                    break;
//                }
//            }
//            if (c) {
//                for (int ii = i; i > 0; i--) {
//                    box[ii] = box[ii - 1];
//                }
//                for (int ii = 0; i < 4; i++) {
//                    box[0][ii] = 0;
//                }
//            }
//        }
    }

    private void paint_me() {

        int nx = (Constant.WINDOW_WIDTH) * Constant.BLOCK + 1;
        int ny = 40;
        int[][] p = nextShape.getPoints();

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                if (p[i][j] == 1) {
                    fill(nextShape.getColor());
                    noStroke();
                    rect(Constant.BLOCK * i + nx,
                            Constant.BLOCK * j + ny,
                            Constant.BLOCK,
                            Constant.BLOCK, 3);
                }
            }
        }

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == 1) {
                    fill(200);
                    noStroke();
                    rect(Constant.BLOCK * i,
                            Constant.BLOCK * j,
                            Constant.BLOCK,
                            Constant.BLOCK, 3);
                }
            }
        }
        p = currentShape.getPoints();
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                int xx = i + point.x;
                int yy = j + point.y;
                if (p[i][j] == 1) {
                    fill(currentShape.getColor());
                    noStroke();
                    rect(Constant.BLOCK * xx,
                            Constant.BLOCK * yy,
                            Constant.BLOCK,
                            Constant.BLOCK, 3);
                }
            }
        }
    }

    private void _resetViewPort() {
        clear();
        fill(0);
        stroke(255);
        strokeWeight(1);
        rectMode(CORNER);
        rect(0, 0, (Constant.WINDOW_WIDTH) * Constant.BLOCK + 1, height - 1, 5);
        rect((Constant.WINDOW_WIDTH) * Constant.BLOCK + 1, 40, Constant.BLOCK * 4, Constant.BLOCK * 4, 5);
        fill(255);
        text("NEXT SHAPE", (Constant.WINDOW_WIDTH) * Constant.BLOCK + 10, 25);
    }

    private void move_down() {
        point.y++;
        int p[][] = currentShape.getPoints();
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                int xx = i + point.x;
                int yy = j + point.y;
                try {
                    if ((xx > 22) || (p[i][j] == 1 && box[xx][yy] == 1)) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    if (zi == 0) {
                        gameOver = true;
                    }
                    zi = -1;
                    reNew = true;
                    point.y--;
                    return;
                }
            }
        }
        zi = 1;
    }

    @Override
    public void keyPressed() {
        if (key == CODED && keyCode == LEFT) {
            move_left();
        } else if (key == CODED && keyCode == RIGHT) {
            move_right();
        } else if (key == CODED && keyCode == UP) {
            currentShape.rotate();
        } else if (key == CODED && keyCode == DOWN) {
            timer.stop();
            timer = new Timer(1_000 / 60, al);
            timer.start();
        }
    }

    private void move_left() {
        point.x--;
        try {
            int p[][] = currentShape.getPoints();
            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < p[i].length; j++) {
                    int xx = i + point.x;
                    int yy = j + point.y;
                    if ((p[i][j] == 1 && box[xx][yy] == 1) || (xx >= 22)) {
                        reNew = true;
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            point.x++;
        }
    }

    private void move_right() {
        point.x++;
        try {
            int p[][] = currentShape.getPoints();
            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < p[i].length; j++) {
                    int xx = i + point.x;
                    int yy = j + point.y;
                    if ((p[i][j] == 1 && box[xx][yy] == 1) || (xx >= 22)) {
                        reNew = true;
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            point.x--;
        }
    }

}
