package ProCon;

public class Producer extends Thread{
    private Market m;
    private long speed;
    public Producer(Market m, String name, long speed) {
        super(name);
        this.m = m;
        this.speed = speed;
        System.out.println("Producer got the market");
    }

    @Override
    public void run() {
        startProducing();
    }

    synchronized private void startProducing() {
        int x = 0;
        while(true) {
            if(m.isNewProduct()) {
                System.out.println("producer walk the consumer..");
                notifyAll();
                //try {
                    System.out.println("producer: sleep");
                    while (!m.isNewProduct()) { }
                //} catch (InterruptedException ex) { }
                System.out.println("producer: walked");
                continue;
            }
            m.put(++x);
            //System.out.println("Producer " + getName() + " : Put " + x);
            System.out.println("Put " + x);
            m.setNewProduct(true);
            System.out.println("producer walk the consumer");
            notifyAll();
            /*try {
                sleep(speed);
            } catch (InterruptedException interruptedException) { }*/
        }
    }
    
}
