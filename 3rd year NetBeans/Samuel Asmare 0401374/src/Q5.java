
import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int rows, cols;
        int[][] firstM, secondM, result;

        System.out.print("Enter the number of rows: ");
        rows = in.nextInt();
        System.out.print("Enter the number of columns: ");
        cols = in.nextInt();

        firstM = new int[rows][cols];
        secondM = new int[rows][cols];
        result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter first matrix element at " + (i + 1) + " " + (j + 1) + ": ");
                firstM[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter second matrix element at " + (i + 1) + " " + (j + 1) + ": ");
                secondM[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = firstM[i][j] * secondM[i][j];
            }
        }

        System.out.println("Result:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + "   ");
            }
            System.out.println();
        }

    }

}
