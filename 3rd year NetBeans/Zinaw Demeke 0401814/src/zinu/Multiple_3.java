package zinu;

import java.util.Scanner;

public class Multiple_3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int f, s;

        System.out.print("Enter the first number: ");
        f = in.nextInt();
        System.out.print("Enter the second number: ");
        s = in.nextInt();

        if (f % s == 0) {
            System.out.println("Multiple");
        } else {
            System.out.println("NOT multiple");
        }

    }

}
