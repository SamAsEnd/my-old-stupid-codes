/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend;

import java.util.ArrayList;

/**
 *
 * @author SamAsEnd
 */
public class Reminder implements Runnable {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<ReminderTime> times;
    static Thread t;

    public static long leftMin() {
        long min = 0;
        if (times.isEmpty()) {
            return 1_000_000L;
        }
        for (ReminderTime reminderTime : times) {
            long x = reminderTime.getTimeRemening();
            if (0 <= x && x <= 1_000) {
                reminderTime.beel();
            }
            if (min > x) {
                min = x;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        times = new ArrayList<>();
        new GUI().setVisible(true);
        t = new Thread(new Reminder());
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            long l = leftMin();
            System.out.println(l);
            synchronized (this) {
                try {
                    wait(l);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    synchronized public static void add(ReminderTime time) {
        times.add(time);
        t.notifyAll();
    }
}
