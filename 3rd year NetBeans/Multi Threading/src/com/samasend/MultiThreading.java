package com.samasend;

/**
 *
 * @author SamAsEnd
 */
public class MultiThreading {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SamThread thread1 = new SamThread("thread1", 2_500);
        SamThread thread2 = new SamThread("thread2", 5_000);
        //SamThread thread3 = new SamThread("thread3", 4_500);
        //SamThread thread4 = new SamThread("thread4", 3_500);
        
        thread1.start();
        thread2.start();
        //thread3.start();
        //thread4.start();
        System.out.println("Main thread exit");
    }
}
