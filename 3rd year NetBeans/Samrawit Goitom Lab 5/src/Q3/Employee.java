package Q3;
/**
 *
 * @author Samrawit Goitom 1608/03
 */
public class Employee {
    
    private int empId;
    protected String empFirstName;
    protected String empMiddleName;
    protected String empLastName;
    
    private String empDepartement;
    private double empSalary;

    public Employee(int empId, String empFirstName, String empMiddleName, String empLastName, String empDepartement, double empSalary) {
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empMiddleName = empMiddleName;
        this.empLastName = empLastName;
        this.empDepartement = empDepartement;
        this.empSalary = empSalary;
    }

    public void dispEmployeeInfo() {
        System.out.println("First Name: "+empFirstName);
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpMiddleName() {
        return empMiddleName;
    }

    public void setEmpMiddleName(String empMiddleName) {
        this.empMiddleName = empMiddleName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpDepartement() {
        return empDepartement;
    }

    public void setEmpDepartement(String empDepartement) {
        this.empDepartement = empDepartement;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
}
