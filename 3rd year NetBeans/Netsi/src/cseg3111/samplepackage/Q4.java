package cseg3111.samplepackage;

/*
 * Netsanet Hailu
 * ID 0401282
 */

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.print("Enter a positive number: ");
        n = in.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "  ");
        }
    }
}
