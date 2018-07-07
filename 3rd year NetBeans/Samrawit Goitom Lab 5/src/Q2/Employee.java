package Q2;
/**
 *
 * @author Samrawit Goitom 1608/03
 */
public abstract class Employee {
    
    public static void main(String[] args) {
        
        Employee emp1 = new Employee() {
            @Override
            public void setEmpName(String empName) {
                this.empName = empName;
            }
            
        };
        
        final int id = 3;
        
        emp1.setEmpName("Henok");
        emp1.setEmpId(1010);
        
        System.out.println(emp1.getEmpName());
        
        System.out.println(emp1.getEmpId());
        
        //     cannot asssign to a final variable
        //      Solution
        //      ========
        //   remove the the accesing operations
        //id = emp1.getEmpId();
        //id = 4;
        
        int eid = emp1.getEmpId();
        System.out.println(eid);
    }
    
    private int empId;
    protected String empName;
    private String empDepartement;
    private double empSalary;

    public void setEmpId(int empId) {
        this.empId = empId;
    }
    
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
