package Q4;

public class PermanentEmploye extends Employee {

    public PermanentEmploye(int empId, String empFirstName, String empMiddleName, String empLastName, String empDepartement, double empSalary) {
        super(empId, empFirstName, empMiddleName, empLastName, empDepartement, empSalary);
    }

    public PermanentEmploye() {
    }

    
    public void dispEmployeeInfo(String fName,String lName) {
        super.dispEmployeeInfo(fName);
        System.out.println("Middle Name: " + lName);
    }
}
