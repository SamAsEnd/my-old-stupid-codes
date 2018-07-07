package com.samasend;

import java.awt.Point;

public class Apple {

    private final Point point;

    private final Board b;

    private int i = 0;

    public Apple(Point point, Board b) {
        this.point = point;
        this.b = b;
    }

    public Point getPoint() {
        return point;
    }

    public void draw() {
        b.fill(255, 255, 0); //yellow
        b.ellipseMode(Board.CORNER);
        b.ellipse(point.x * Snake.BLOCK_WIDTH + i,
                point.y * Snake.BLOCK_WIDTH + i,
                Snake.BLOCK_WIDTH - i,
                Snake.BLOCK_WIDTH - i);
        if(++i > 5) {
            i = 0;
        } 
    }
}
