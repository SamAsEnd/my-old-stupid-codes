package com.samasend;

import java.awt.Color;
import java.awt.Point;

public class Car {

    private Point point;

    private Color color;

    public Car(Point point, Color color) {
        this.point = point;
        this.color = color;
    }

    public boolean isAt(Point p) {
        return p.x == point.x && Math.abs(p.y - point.y) < 50.0;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
