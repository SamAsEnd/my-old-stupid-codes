package cseg3111.samplepackage;

/*
 * Samson Kidu 0401368
 */

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.print("Enter a number: ");
        n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "  ");
        }
    }
}
