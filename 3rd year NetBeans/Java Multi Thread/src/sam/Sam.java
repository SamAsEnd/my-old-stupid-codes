package sam;

import java.util.Scanner;

public class Sam {
    public static void main(String[] args) throws InterruptedException{
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter a number: ");
        MyThread myThread = new MyThread();
        myThread.start();
        String r = cin.next();
        System.out.println("you enterd" + r);
        myThread.stop();
        System.out.println("Thread2 reached: " + myThread.x);
    }
}
class MyThread extends Thread {
    int x = 1;
    @Override
    public void run() {
        while (true) {            
            Math.log(x);
            x++;
        }
    } 
}