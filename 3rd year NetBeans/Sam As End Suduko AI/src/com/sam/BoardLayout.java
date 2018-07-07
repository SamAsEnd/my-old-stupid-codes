/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Sam As End
 *
 * @author Sam As End
 */
public class BoardLayout {

    private int[] val;
    private ArrayList<BoardLayout> list;
    public BoardLayout(int[] val) {
        this.val = val;
        list = new ArrayList<>(10);
        for (int i = 0; i < val.length; i++) {
            if (val[i] == 0) {
                int[] x = val.clone();
                for (int j = 1; j < 9; j++) {
                    x[i] = j;
                    System.out.println(i+"  Added");
                    list.add(new BoardLayout(x.clone()));
                }
            }
        }
    }

    public boolean collision() {
        for (Iterator<BoardLayout> it = list.iterator(); it.hasNext();) {
            BoardLayout boardLayout = it.next();
            if (boardLayout.collision()) {
                list.remove(boardLayout);
            }
        }
        for (Iterator<BoardLayout> it = list.iterator(); it.hasNext();) {
            BoardLayout boardLayout = it.next();
            System.out.println(boardLayout.toString());
        }
        if (numberOfCheak()) {
            return true;
        }
        return false;
    }

    private boolean numberOfCheak() {
        int[] n = new int[10];
        for (int i = 0; i < val.length; i++) {
            try {
                n[val[i]]++;
            } catch (Exception e) {
                return true;
            }
        }
        for (int i : n) {
            if (i > 9) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
                + val.toString()
                + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        return str;
    }

    public static void main(String[] args) {
        int[] i = 
        {   1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 0, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3,
            1 , 5 , 8, 9, 4, 7, 6, 2, 3
        };
        BoardLayout boardLayout = new BoardLayout(i);
        
    }
}
