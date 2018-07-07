
import java.util.Scanner;

public class TestClass implements Artimatic_Opretions {

    public static void main(String[] args) {

        TestClass testClass = new TestClass();

        double result = testClass.div();
        System.out.println("Result:  "+result);
    }

    @Override
    public double add() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double sub() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double mul() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double div() {
        double x, y;
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the first number:  ");
        x = cin.nextDouble();
        System.out.print("Enter the second number:  ");
        y = cin.nextDouble();

        return (x / y);
    }
}
