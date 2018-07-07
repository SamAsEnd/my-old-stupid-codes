package j2ee;


import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {

        int[][] a, b, pro;
        Scanner in = new Scanner(System.in);
        int row, col;

        System.out.print("Enter the number of rows:    ");
        row = in.nextInt();
        System.out.print("Enter the number of columns: ");
        col = in.nextInt();

        a = new int[row][col];
        b = new int[row][col];
        pro = new int[row][col];

        System.out.println("Enter the first matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter the element at " + (i + 1) + ", " + (j + 1) + ": ");
                a[i][j] = in.nextInt();
            }
        }
        System.out.println("Enter the second matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter the element at " + (i + 1) + ", " + (j + 1) + ": ");
                b[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pro[i][j] = a[i][j] * b[i][j];
            }
        }

        System.out.println("\nProduct of the matrices");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%3d ", pro[i][j]);
            }
            System.out.println();
        }

    }

}
