
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a, b, c, temp;
        double x1, x2;

        System.out.print("Enter a: ");
        a = in.nextInt();
        System.out.print("Enter b: ");
        b = in.nextInt();
        System.out.print("Enter c: ");
        c = in.nextInt();

        temp = (b * b) - (4 * a * c);

        if (temp < 0) {
            System.out.println("NO solution");
        } else if (temp == 0) {
            x1 = (-b + Math.sqrt(temp)) / (2 * a);
            System.out.println("One solution");
            System.out.println("    X = " + x1);
        } else {
            x1 = (-b + Math.sqrt(temp)) / (2 * a);
            x2 = (-b - Math.sqrt(temp)) / (2 * a);
            System.out.println("Two solution");
            System.out.println("    X = " + x1);
            System.out.println("    X = " + x2);
        }

    }

}
