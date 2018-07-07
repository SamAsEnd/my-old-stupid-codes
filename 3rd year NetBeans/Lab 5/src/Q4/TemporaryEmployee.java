package Q4;

public class TemporaryEmployee extends Employee {

    public String dispEmployeeInfo(String fName,String mName,String lName) {
        return (super.dispEmployeeInfo(fName) + " " + mName + " " + lName);
    }
    
}
