package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class PermanentEmployeeTest {

    public static void main(String[] args) { 
        PermanentEmployee permanentEmployee = new PermanentEmployee("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 99999.99,5);
        
        System.out.println("PermanentEmployee Name           : " + permanentEmployee.getPerName());
        System.out.println("PermanentEmployee Age            : " + permanentEmployee.getPerAge());
        System.out.println("PermanentEmployee Field Of Study : " + permanentEmployee.getFieldOfStudy());
        System.out.println("PermanentEmployee Phone Number   : " + permanentEmployee.getPhoneNumber());
        System.out.println("PermanentEmployee Gross Salary   : " + permanentEmployee.getGrossSalary());
        System.out.println("PermanentEmployee Pension        : " + permanentEmployee.getPension());
        System.out.println("PermanentEmployee Net-Salary     : " + permanentEmployee.getNetSalary());
        System.out.println("PermanentEmployee Total Income   : " + permanentEmployee.calcTotalIncome());
        
    }
}
