package com.samasend;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import processing.core.PApplet;

public class Track extends PApplet {

    ArrayList<Car> cars;
    Car me;
    int trackBackground = 0;

    @Override
    public void setup() {
        cars = new ArrayList<>();
        me = new Car(new Point(2, 8), Color.WHITE);
        size(170, 400);
        setBackground(Color.BLACK);
        new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myLoop();
            }
        }).start();

        noLoop();
    }

    @Override
    public void draw() {
        setBackground(Color.BLACK);
        setForeground(Color.BLACK);
        rect(0, 0, width, height);
        setForeground(Color.WHITE);
        for (int i = 0; i < height; i += 40) {
            if (i % 4 == trackBackground) {
                rect(0, i, 10, 10);
                rect(160, i, 10, 10);
            }
        }
        trackBackground++;
        if (trackBackground > 3) {
            trackBackground = 0;
        }
    }

    private void myLoop() {
        redraw();
    }
}
