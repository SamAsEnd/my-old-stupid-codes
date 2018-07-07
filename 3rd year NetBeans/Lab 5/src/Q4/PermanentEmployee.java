package Q4;

public class PermanentEmployee extends Employee {

    public String dispEmployeeInfo(String fName,String mName) {
        return (super.dispEmployeeInfo(fName) + " " + mName);
    }
    
}
