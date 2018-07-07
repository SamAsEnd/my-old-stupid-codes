package Q4;

public class TemporaryEmployee extends Employee {

    public TemporaryEmployee(int empId, String empFirstName, String empMiddleName, String empLastName, String empDepartement, double empSalary) {
        super(empId, empFirstName, empMiddleName, empLastName, empDepartement, empSalary);
    }

    public TemporaryEmployee() {
    }

    public void dispEmployeeInfo(String fName,String mName,String lName) {
        super.dispEmployeeInfo(fName);
        System.out.println("Middle Name: "+mName);
        System.out.println("Last Name: "+lName);
    }
}
