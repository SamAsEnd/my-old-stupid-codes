package Q3;

public class TemporaryEmployee extends Employee {

    public TemporaryEmployee(String fName, String mName, String lName) {
        super(fName, mName, lName);
    }

    @Override
    public void dispEmployeeInfo() {
        super.dispEmployeeInfo();
        System.out.print(" " + mName + " " + lName);
    }
}
