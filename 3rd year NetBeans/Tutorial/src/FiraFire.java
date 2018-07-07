
public abstract class FiraFire {

    protected String name, color, test;
    protected int seedNumber;

    public FiraFire() {
        ;
    }

    public FiraFire(String name, String color, String test, int seedNumber) {
        this(name, color, test);
        this.seedNumber = seedNumber;
    }

    public FiraFire(String name, String color, String test) {
        this.name = name;
        this.color = color;
        this.test = test;
    }

    static String FiraFiraLogic() {
        return "Ethiopia firaFira can be wild or farmerised !!";
    }

    abstract boolean hasSeed();

    abstract boolean hasCaffine();

    protected abstract boolean isSweet(String color);
}
