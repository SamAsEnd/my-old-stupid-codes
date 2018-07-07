package Q1;

public abstract class Employee {
    
    private int empId;
    protected String empName;
    private String empDepartment;
    private float empSalary;

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
    // Error: abstract body can't have a body
    public abstract void setEmpName(String empName);

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
    
    public static void main(String[] args) {
        Employee emp1 = new EmployeeImpl();
        emp1.setEmpName("Henok");
        System.out.println(emp1.getEmpName());
    }
}
