package csed3111_lab4;

public class PermanentEmployee extends Employee{
    
    private int ovetTimePerWeek;
    
    public PermanentEmployee(int ovetTimePerWeek, double grossSalary, String perName, int perAge, String fieldOfStudy, String phoneNumber) {
        super(grossSalary, perName, perAge, fieldOfStudy, phoneNumber);
        this.ovetTimePerWeek = ovetTimePerWeek;
    }

    public double calcTotalIncome() {
        double totalIncome = ovetTimePerWeek * 80 + getNetSalary();
        return totalIncome;
    }
    
}
