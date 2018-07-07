package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class Employee extends Person {

    private double grossSalary;
    private double netSalary;
    private double pension;

    public Employee(String perName, int perAge, String fieldOfStudy, long phoneNumber, double grossSalary) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.grossSalary = grossSalary;
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
        calcPension();
        return pension;
    }

    public void setPension(double pension) {
        this.pension = pension;
    }

    public void calcPension() {
        pension = 0.04 * grossSalary;
    }

    public void calcNetSalary() {
        double rate;
        if (grossSalary >= 5000) {
            rate = 0.35;
        } else if (grossSalary >= 4000) {
            rate = 0.25;
        } else if (grossSalary >= 3000) {
            rate = 0.2;
        } else if (grossSalary >= 1500) {
            rate = 0.15;
        } else {
            rate = 0.1;
        }
        double tax = grossSalary * rate;
        calcPension();
        netSalary = grossSalary - tax - pension;
    }
}
