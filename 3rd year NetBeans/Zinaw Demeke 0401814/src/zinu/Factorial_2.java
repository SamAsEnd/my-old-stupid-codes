package zinu;

import java.util.Scanner;

public class Factorial_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int i, factorial;

        System.out.print("Enter the number: ");
        i = in.nextInt();

        factorial = 1;
        while (i > 0) {
            factorial = factorial * i;
            i--;
        }

        System.out.println("The factorial: " + factorial);

    }

}
