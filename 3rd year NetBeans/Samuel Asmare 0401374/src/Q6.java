
import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double salary, grossSalary, HRA, DA;

        System.out.println("Enter the salary: ");
        salary = in.nextDouble();

        if (salary < 1500) {
            HRA = salary * 0.10;
            DA = salary * 0.90;
        } else {
            HRA = 500;
            DA = salary * 0.98;
        }

        grossSalary = salary + HRA + DA;

        System.out.println("Gross salary: " + grossSalary);
    }

}
