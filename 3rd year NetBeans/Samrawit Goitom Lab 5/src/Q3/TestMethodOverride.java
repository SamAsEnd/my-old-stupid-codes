package Q3;

public class TestMethodOverride {
    public static void main(String[] args) {
        Employee employee = new Employee(1010, "Samrawit", "Goitom", "G/her", "CSED", 10_000);
        PermanentEmploye permanentEmploye = new PermanentEmploye(1010, "Samrawit", "Goitom", "G/her", "CSED", 10_000);
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(1010, "Samrawit", "Goitom", "G/her", "CSED", 10_000);
        
        System.out.println(employee.getClass().getName());
        employee.dispEmployeeInfo();
        
        System.out.println();
        System.out.println(permanentEmploye.getClass().getName());
        permanentEmploye.dispEmployeeInfo();
        
        System.out.println();
        System.out.println(temporaryEmployee.getClass().getName());
        temporaryEmployee.dispEmployeeInfo();        
    }
}
