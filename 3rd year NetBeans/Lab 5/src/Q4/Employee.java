package Q4;

public class Employee {

    private int empId;
    protected String fName;
    protected String mName;
    protected String lName;
    private String empDepartment;
    private float empSalary;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public void setEmpSalary(float empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String dispEmployeeInfo(String fName) {
        return fName;
    }
}
