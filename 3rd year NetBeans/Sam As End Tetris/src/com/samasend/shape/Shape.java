/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend.shape;

/**

 @author SamAsEnd
 */
public abstract class Shape implements ShapedPreDefine {

    public static Shape randomShape(int i) {
        switch (i) {
            case 0:
                return new Bar();
            case 1:
                return new Box();
            case 2:
                return new Crown();
            case 3:
                return new Five();
            case 4:
                return new L();
            case 5:
                return new Seven();
            case 6:
                return new Two();
            default:
                // don't even ask me if it's 7 
                // it might b 7 but it's rare
                // if it's --> it will do this again
                return randomShape((int) ((Math.random() * 7.0)));
        }
    }

    private final int[][] points;
    private int color;

    public Shape(int[][] points, int color) {
        this.points = points;
        this.color = color;
    }

    public void rotate() {
        int[][] temp = new int[4][4];
        for (int i = 0, ii = 3; i < 4; i++, ii--) {
            for (int j = 0, jj = 3; j < 4; j++, jj--) {
                temp[i][j] = points[jj][i];
            }
        }
        for (int i = 0; i < 4; i++) {
            System.arraycopy(temp[i], 0, points[i], 0, 4);
        }

    }

    public int[][] getPoints() {
        return points;
    }

    public int getColor() {
        return color;
    }

}
