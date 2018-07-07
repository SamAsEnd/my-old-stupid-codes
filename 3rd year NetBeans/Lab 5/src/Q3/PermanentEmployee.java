package Q3;

public class PermanentEmployee extends Employee {

    public PermanentEmployee(String fName, String mName, String lName) {
        super(fName, mName, lName);
    }

    @Override
    public void dispEmployeeInfo() {
        super.dispEmployeeInfo();
        System.out.print(" " + mName);
    }
}
