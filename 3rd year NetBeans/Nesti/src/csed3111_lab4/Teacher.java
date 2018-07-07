package csed3111_lab4;

public class Teacher extends Person{
    
    private int totalCreditHour;
    private double netSalary;

    public Teacher(int totalCreditHour, double netSalary, String perName, int perAge, String fieldOfStudy, String phoneNumber) {
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
