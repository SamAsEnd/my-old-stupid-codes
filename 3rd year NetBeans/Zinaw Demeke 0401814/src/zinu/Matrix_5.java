package zinu;

import java.util.Scanner;

public class Matrix_5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int row, column;
        int[][] first, second, result;

        System.out.print("Enter the number of rows: ");
        row = in.nextInt();
        System.out.print("Enter the number of columns: ");
        column = in.nextInt();

        first = new int[row][column];
        second = new int[row][column];
        result = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter 1st matrix " + (i + 1) + " " + (j + 1) + ": ");
                first[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter 2nd matrix " + (i + 1) + " " + (j + 1) + ": ");
                second[i][j] = in.nextInt();
                result[i][j] = first[i][j] * second[i][j];
            }
        }

        System.out.println("Result: ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(result[i][j] + "   ");
            }
            System.out.println();
        }

    }

}
