package ProCon;

public class Market {

    int data;

    public Market(int data) {
        this.data = data;
        System.out.println("Market Created");
    }

    public Market() {
        this(0);
    }
    
    private boolean newProduct;

    public boolean isNewProduct() {
        return newProduct;
    }

    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }

    
    synchronized public int get() {
        return data;
    }

    synchronized public void put(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market, "Sam As End", 1_000);
        Consumer consumer1 = new Consumer(market, "Abebe", 500);
        //Consumer consumer2 = new Consumer(market,"Chala" ,500);
        //Consumer consumer3 = new Consumer(market,"Kebede" ,500);

        producer.start();
        consumer1.start();
        //consumer2.start();
        //consumer3.start();

    }
}
