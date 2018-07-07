
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num, fact;

        System.out.print("Enter the number: ");
        num = in.nextInt();

        fact = 1;
        while (num > 0) {
            fact = fact * num;
            num--;
        }

        System.out.println("The factorial is " + fact);

    }

}
