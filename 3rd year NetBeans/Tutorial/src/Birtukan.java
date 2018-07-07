
public class Birtukan extends FiraFire implements YeguaroAtkilt, DisplayObject {

    public Birtukan() {
        ;
    }

    public Birtukan(String name, String color, String test, int seedNumber) {
        super(name, color, test, seedNumber);
    }

    public static String FiraFiraLogic() {
        return "hulume birtukanoch becha heber alacew !!!";
    }

    public boolean hasTest() {
        if (!test.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean isSweet(String color) {
        if (color.equals("yellow")) {
            return true;
        } else {
            return false;
        }
    }

    public String hasColor() {
        return color;
    }

    public boolean hasSeed() {
        return true;
    }

    public boolean hasCaffine() {
        return false;
    }

    public void displayInTabular() {
        System.out.println("Here is the birtukan info in tabular form !!!!");
        System.out.println("name \tcolor\t test\tseednumber");
        System.out.println(name + "\t" + color + "\t" + test + "\t" + seedNumber);
    }
    
    /*
        ERROR 1:
            this method was not implemented
    */
    public String showInfo() {
        return (name + "\t" + color + "\t" + test + "\t" + seedNumber);
    }

    @Override
    public String toString() {
        return ("This is a Birtukan");
    }
    
    
}
