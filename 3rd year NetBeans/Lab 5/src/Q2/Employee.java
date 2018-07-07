package Q2;

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
        final int id = 3;
        Employee emp1 = new EmployeeImpl();
        emp1.setEmpName("Henok");
        emp1.setEmpId(1010);
        
        System.out.println(emp1.getEmpName());
        
        System.out.println(emp1.getEmpId());
        // can't
        //id = emp1.getEmpId();
        //id = 4;
        
        System.out.println(id);
        int eid = emp1.getEmpId();
        System.out.println(eid);
    }
}
