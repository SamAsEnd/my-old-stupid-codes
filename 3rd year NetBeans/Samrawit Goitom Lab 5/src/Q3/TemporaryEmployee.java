package Q3;

public class TemporaryEmployee extends Employee {

    public TemporaryEmployee(int empId, String empFirstName, String empMiddleName, String empLastName, String empDepartement, double empSalary) {
        super(empId, empFirstName, empMiddleName, empLastName, empDepartement, empSalary);
    }

    @Override
    public void dispEmployeeInfo() {
        super.dispEmployeeInfo();
        System.out.println("Middle Name: "+getEmpMiddleName());
        System.out.println("Last Name: "+getEmpLastName());
    }

}
