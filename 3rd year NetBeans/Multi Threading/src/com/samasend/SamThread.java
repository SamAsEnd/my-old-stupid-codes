package com.samasend;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SamAsEnd
 */
public class SamThread extends Thread {

    private long delay;

    public SamThread(String name, long delay) {
        super(name);
        this.delay = delay;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread: " + getName() + " (" + getId() + ")  is runing");
            try {
                synchronized (this) {
                    wait(delay);
                }
            } catch (InterruptedException ex) {
                System.out.println("Thread: " + getName() + " (" + getId() + ") is InterruptedException: " + ex.getMessage());
            }
        }
    }
}
