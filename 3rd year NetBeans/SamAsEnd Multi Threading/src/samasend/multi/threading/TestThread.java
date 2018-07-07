package samasend.multi.threading;

import sun.awt.windows.ThemeReader;

public class TestThread extends Thread{

    public TestThread() {
    }

    @Override
    public void run() {
        super.run();
        print();
    }
    
    private void print() {
        int x = 0;
        while(true) {
            System.out.println(String.format("Thread %d  now at %d", getId(),++x));
            try {
                sleep(1_000);
            } catch (InterruptedException interruptedException) { }
        }
    }
}
