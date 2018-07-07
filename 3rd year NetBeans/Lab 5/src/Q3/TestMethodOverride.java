package Q3;

public class TestMethodOverride {

    public static void main(String[] args) {
        Employee employee = new Employee("Abebe", "Beso", "Bela");
        PermanentEmployee permanentEmployee = new PermanentEmployee("Abebe", "Beso", "Bela");
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee("Abebe", "Beso", "Bela");
        
        employee.dispEmployeeInfo();
        System.out.println();
        permanentEmployee.dispEmployeeInfo();
        System.out.println();
        temporaryEmployee.dispEmployeeInfo();
        System.out.println();
        
    }
}
