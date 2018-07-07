package csed3111_lab4;

public class Teacher extends Person{
    
    private int totalCreditHour;
    private double netSalary;

    public Teacher(String perName, String perAge, String fieldOfStudy, long phoneNumber,int totalCreditHour, double netSalary) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.totalCreditHour = totalCreditHour;
        this.netSalary = netSalary;
    }

    public int getTotalCreditHour() {
        return totalCreditHour;
    }

    public void setTotalCreditHour(int totalCreditHour) {
        this.totalCreditHour = totalCreditHour;
    }

    public double getNetSalary() {
        return netSalary;
    }
    
    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
    
}
