package csed3111_lab4;

public class Employee extends Person {

    private double grossSalary;
    private double netSalary;
    private double pension;

    public Employee(double grossSalary, String perName, String perAge, String fieldOfStudy, long phoneNumber) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.grossSalary = grossSalary;

    }

    public void calcPansion(double Rate) {
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        calcNetSalary();
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public double getPension() {
        calcPansion();
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }
}
