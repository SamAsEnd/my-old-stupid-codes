package Q1;
/**
 *
 * @author Samrawit Goitom 1608/03
 */
public abstract class Employee {
    
    public static void main(String[] args) {
        //   Employe is abstract; cannot be instatntiated
        //      Solution
        //      ========
        //   create an implementing class EmployeeImpl
        Employee emp1 = new EmployeeImpl();
        
        emp1.setEmpName("Henok");
        emp1.setEmpId(1010);
        
        System.out.println(emp1.getEmpName());
    }
    
    private int empId;
    protected String empName;
    private String empDepartement;
    private double empSalary;

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    //  abstract cannot have a body
    //   Solution
    //   ========
    //   remove the body
    public abstract void setEmpName(String empName);

    public void setEmpDepartement(String empDepartement) {
        this.empDepartement = empDepartement;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}
