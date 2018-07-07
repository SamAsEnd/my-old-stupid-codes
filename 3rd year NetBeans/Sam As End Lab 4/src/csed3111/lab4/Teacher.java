package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */ 
public class Teacher extends Person {

    private int totalCreditHour;
    private double netSalary;

    public Teacher(String perName, int perAge, String fieldOfStudy, long phoneNumber, int totalCreditHour, double netSalary) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.totalCreditHour = totalCreditHour;
        this.netSalary = netSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public int getTotalCreditHour() {
        return totalCreditHour;
    }

    public void setTotalCreditHour(int totalCreditHour) {
        this.totalCreditHour = totalCreditHour;
    }
}
