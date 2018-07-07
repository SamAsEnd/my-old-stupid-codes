package csed3111.lab4;

/**
 *
 * @author Sam As End
 */
public class TemporaryEmployeeTest {
    public static void main(String[] args) { 
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 99999.99, 20);
        
        System.out.println("TemporaryEmployee Name           : " + temporaryEmployee.getPerName());
        System.out.println("TemporaryEmployee Age            : " + temporaryEmployee.getPerAge());
        System.out.println("TemporaryEmployee Field Of Study : " + temporaryEmployee.getFieldOfStudy());
        System.out.println("TemporaryEmployee Phone Number   : " + temporaryEmployee.getPhoneNumber());
        System.out.println("TemporaryEmployee Gross Salary   : " + temporaryEmployee.getGrossSalary());
        System.out.println("TemporaryEmployee Pension        : " + temporaryEmployee.getPension());
        System.out.println("TemporaryEmployee Net-Salary     : " + temporaryEmployee.getNetSalary());
        System.out.println("TemporaryEmployee Total Pay      : " + temporaryEmployee.calcTotalPay());
        
    }
}
