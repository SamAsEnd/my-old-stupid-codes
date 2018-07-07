package Q5;

import Q4.Employee;
import Q4.PermanentEmployee;
import Q4.TemporaryEmployee;
import java.io.Serializable;
import javax.swing.JFrame;

public class TestMethodOverride implements Serializable{

    public static void main(String[] args) {
        Employee employee = new Employee();
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee();

        System.out.println(employee.dispEmployeeInfo("Abebe"));
        System.out.println(permanentEmployee.dispEmployeeInfo("Abebe", "Beso"));
        System.out.println(temporaryEmployee.dispEmployeeInfo("Abebe", "Beso", "Bela"));

    }
    
    

}
