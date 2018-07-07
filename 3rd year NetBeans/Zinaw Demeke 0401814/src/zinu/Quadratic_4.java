package zinu;

import java.util.Scanner;

public class Quadratic_4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a, b, c, t;
        double x1, x2;

        System.out.print("Enter a: ");
        a = in.nextInt();
        System.out.print("Enter b: ");
        b = in.nextInt();
        System.out.print("Enter c: ");
        c = in.nextInt();

        t = (b * b) - (4 * a * c);

        if (t < 0) {
            System.out.println("NO solution");
        } else if (t == 0) {
            x1 = (-b + Math.sqrt(t)) / (2 * a);
            System.out.println("One solution");
            System.out.println("X = " + x1);
        } else {
            x1 = (-b + Math.sqrt(t)) / (2 * a);
            x2 = (-b - Math.sqrt(t)) / (2 * a);
            System.out.println("Two solution");
            System.out.println("X = " + x1);
            System.out.println("X = " + x2);
        }

    }

}
