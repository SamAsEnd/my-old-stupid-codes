
public class TutorialExcersiseOnOOPConcepts {

    public static void main(String[] args) {

        Muzz mz = new Muzz();

        Muzz m = new Muzz("Guuradaa", "Bichaa", "Tafach", 0);

        System.out.println(mz);
        System.out.println("Does Muuz has seed?  :  " + hasSeed(m));
        System.out.println("Is Green muuz sweet? " + isSweet(m));
        displayInTabular(m);

        Birtukan biru = new Birtukan("Methara", "YellowGreen", "Tafach", 9);

        System.out.println(biru);
        System.out.println("Birtukan always have seed?  :  " + hasSeed(biru));
        System.out.println("Is Black Birtukan sweet? " + isSweet(biru));
        System.out.println("What is the usual test of Birtukan? :8" + biru.test);
        displayInTabular(biru);

    }

    public static boolean hasSeed(FiraFire fru) {
        return fru.hasSeed();
    }

    public static boolean isSweet(FiraFire fru) {
        return fru.isSweet("Green");
    }

    public static boolean hasTest(YeguaroAtkilt yeg) {
        return yeg.hasTest();
    }

    public static void displayInTabular(DisplayObject disObj) {
        disObj.displayInTabular();
    }

}
