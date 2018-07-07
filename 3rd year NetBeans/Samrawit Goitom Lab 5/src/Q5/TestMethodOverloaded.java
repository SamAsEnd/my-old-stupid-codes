package Q5;

import Q4.Employee;
import Q4.PermanentEmploye;
import Q4.TemporaryEmployee;

public class TestMethodOverloaded {

    public static void main(String[] args) {
        Employee employee = new Employee();
        PermanentEmploye permanentEmploye = new PermanentEmploye();
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee();

        System.out.println(employee.getClass().getName());
        employee.dispEmployeeInfo("Samrawit");

        System.out.println();
        System.out.println(permanentEmploye.getClass().getName());
        permanentEmploye.dispEmployeeInfo("Samrawit", "Goitom");

        System.out.println();
        System.out.println(temporaryEmployee.getClass().getName());
        temporaryEmployee.dispEmployeeInfo("Samrawit", "Goitom", "G/her");
    }
}
