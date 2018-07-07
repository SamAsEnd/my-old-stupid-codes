
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double i, money, rate, t;

        System.out.print("Enter the money: ");
        money = in.nextDouble();
        System.out.print("Enter the time(in years): ");
        t = in.nextDouble();
        System.out.print("Enter the rate(in %): ");
        rate = in.nextDouble();

        i = money * (rate / 100) * t;

        System.out.println("Interest = " + i);

    }

}
