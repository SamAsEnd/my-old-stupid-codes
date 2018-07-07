package zinu;

import java.util.Scanner;

public class GrossSalary_6 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double s, gs, HRA, DA;

        System.out.println("Enter the salary: ");
        s = in.nextDouble();

        if (s < 1500) {
            HRA = s * 0.10;
            DA = s * 0.90;
        } else {
            HRA = 500;
            DA = s * 0.98;
        }

        gs = s + HRA + DA;

        System.out.println("Gross salary = " + gs);
    }

}
