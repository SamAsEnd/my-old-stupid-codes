package Q3;

public class PermanentEmploye extends Employee {

    public PermanentEmploye(int empId, String empFirstName, String empMiddleName, String empLastName, String empDepartement, double empSalary) {
        super(empId, empFirstName, empMiddleName, empLastName, empDepartement, empSalary);
    }

    @Override
    public void dispEmployeeInfo() {
        super.dispEmployeeInfo();
        System.out.println("Middle Name: "+getEmpMiddleName());
    }
    
}
