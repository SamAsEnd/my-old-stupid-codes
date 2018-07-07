package old;

public class Vehicle {

    public String name;
    public int wing;
    public int maxSpeed;
    public String type;
    public int tire;
    public int gear;
    public static boolean started;

    public void start() {
        if (started) {
            System.out.println(this.name + "Aleardy Started!!");
        } else {
            Vehicle.started = true;
            System.out.println(this.name + " Started!!");
        }
    }
    
    public void stop() {
        if (started) {
            Vehicle.started = false;
            System.out.println(this.name + " Stopped!!");
        } else {
            System.out.println(this.name + "Aleardy Stopped!!");
        }
    }

    public Vehicle(String s, int w, int m, String St, int bt) {
        this.name = s;
        this.wing = w;
        this.maxSpeed = m;
        this.type = St;
        this.tire = bt;
        Vehicle.started = false;
        System.out.println(this.name+" has been created!!");
    }

    public static void main(String[] arg) {
        Vehicle t = new Vehicle("Sami",0,20,"Human",2);
        Vehicle z = new Vehicle("Yaregal",0,20,"Human",3);
        t.start();
        t.start();
        z.start();
        t.stop();
        z.stop();
        t.stop();
        t.start();
        z.start();
        t.start();
        
    }
}
