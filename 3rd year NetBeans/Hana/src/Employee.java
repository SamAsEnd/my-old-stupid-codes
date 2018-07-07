public class Employee extends CustomerInformation{
    
    private int employeeID;

    public Employee() {
    }
    
    public Employee(String name, char sex, String birthDate,int employeeID) {
        super(name, sex, birthDate);
        this.employeeID = employeeID;
    }

    public String request() {
        return "request from employee";
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

}
