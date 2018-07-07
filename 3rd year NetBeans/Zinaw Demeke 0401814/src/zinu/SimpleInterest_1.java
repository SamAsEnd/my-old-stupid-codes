package zinu;

import java.util.Scanner;

public class SimpleInterest_1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double interest, value, period, r;

        System.out.print("Enter the value: ");
        value = input.nextDouble();
        System.out.print("Enter the period(in years): ");
        period = input.nextDouble();
        System.out.print("Enter the rate(in %): ");
        r = input.nextDouble();

        interest = value * (r / 100) * period;

        System.out.println("Interest = " + interest);

    }

}
