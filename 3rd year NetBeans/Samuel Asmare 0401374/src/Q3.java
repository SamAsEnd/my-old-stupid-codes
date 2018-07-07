
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int firstNumber, secondNumber;

        System.out.print("Enter the first number: ");
        firstNumber = in.nextInt();
        System.out.print("Enter the second number: ");
        secondNumber = in.nextInt();

        if (firstNumber % secondNumber == 0) {
            System.out.println(firstNumber + " is the multiple of " + secondNumber);
        } else {
            System.out.println(firstNumber + " is the NOT multiple of " + secondNumber);
        }

    }

}
