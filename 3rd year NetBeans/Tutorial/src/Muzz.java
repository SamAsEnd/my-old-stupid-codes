
public class Muzz extends FiraFire implements DisplayObject, YeguaroAtkilt {

    public Muzz() {
        ;
    }

    public Muzz(String name, String col, String test, int seedNumber) {
        super(name, col, test, seedNumber);
    }

    static String FiraFireLogic() {
        return "Ethiopian MUUZ is only farmerized  type!";
    }

    protected boolean isSweet(String color) {
        if (color.equals("YellowGreen")) {
            return true;
        } else {
            return false;
        }
    }

    public String showInfo() {
        return ("Muzz Info => " + name + " " + color + " " + test);
    }

    public void displayInTabular() {
        System.out.println("Here is the Muuz Info in Tabular form!");
        System.out.println("Name\tColor\ttest\tseedNumber");
        System.out.println(name + "\t" + color + "\t" + test+ "\t" + seedNumber);
    }
    
    public boolean hasSeed() {
        return false;
    }
    
    public boolean hasCaffine() {
        return true;
    }

    /*
        ERROR 2:
            this method was not implemented
    */
    public boolean hasTest() {
        if (!test.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    /*
        ERROR 3:
            this method was not implemented
    */
    public String hasColor() {
        return color;
    }

    @Override
    public String toString() {
        return ("This is a Muzz");
    }
    
}

