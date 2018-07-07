package ProCon;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread{
    private Market m;
    private long speed;
    public Consumer(Market m, String name, long speed) {
        super(name);
        this.m = m;
        this.speed = speed;
        System.out.println("Consumer got the market");
    }
    
    @Override
    public void run() {
        startConsuming();
    }

    synchronized private void startConsuming() {
        while(true) {
            //System.out.println("Consumer " + getName() + "Get " + m.get());
            if(!m.isNewProduct()) {
                System.out.println("consumer walk the producer..");
                notifyAll();
                //try {
                    System.out.println("consumer: sleep");
                    while (m.isNewProduct()) { }
                //} catch (InterruptedException ex) { }
                System.out.println("consumer: walked");
                continue;
            }
            System.out.println("Get " + m.get());
            m.setNewProduct(false);
            System.out.println("consumer walk the producer");
            notifyAll();
            //System.exit(0);
            /*try {
                sleep(speed);
            } catch (InterruptedException interruptedException) { }*/
        }
    }
    
}
