package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class EmployeeTest {

    public static void main(String[] args) { 
        Employee employee = new Employee("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 99999.99);
        
        System.out.println("Employee Name           : " + employee.getPerName());
        System.out.println("Employee Age            : " + employee.getPerAge());
        System.out.println("Employee Field Of Study : " + employee.getFieldOfStudy());
        System.out.println("Employee Phone Number   : " + employee.getPhoneNumber());
        System.out.println("Employee Gross Salary   : " + employee.getGrossSalary());
        System.out.println("Employee Pension        : " + employee.getPension());
        System.out.println("Employee Net-Salary     : " + employee.getNetSalary());
        
    }
}
