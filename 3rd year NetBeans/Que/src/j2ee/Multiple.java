package j2ee;


import java.util.Scanner;

public class Multiple {

    public static void main(String[] args) {

        int f, s;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the first number:  ");
        f = in.nextInt();
        System.out.print("Enter the second number: ");
        s = in.nextInt();

        if (f % s == 0) {
            System.out.println(f + " is the multiple of " + s);
        } else {
            System.out.println(f + " is NOT the multiple of " + s);
        }
    }

}
