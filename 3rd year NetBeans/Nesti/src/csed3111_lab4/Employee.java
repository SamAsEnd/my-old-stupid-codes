package csed3111_lab4;

public class Employee extends Person{
    
    private double grossSalary;
    private double netSalary;
    private double pension;

    public Employee(double grossSalary, String perName, int perAge, String fieldOfStudy, String phoneNumber) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.grossSalary = grossSalary;
    }
    
    public void calcNetSalary() {
        double rate;
        if(grossSalary >= 5000) {
            rate = 0.35;
        }
        else if(grossSalary >= 4000) {
            rate = 0.25;
        }
        else if(grossSalary >= 3000) {
            rate = 0.20;
        }
        else if(grossSalary >= 1500) {
            rate = 0.15;
        }
        else {
            rate = 0.1;
        }
        
        double tax = grossSalary * rate;
        netSalary = grossSalary - tax - getPension();
    }
    
    public void calcPension() {
        double r = grossSalary * 0.04;
        pension = r;
    }

    public double getNetSalary() {
        calcNetSalary();
        return netSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getPension() {
        calcPension();
        return pension;
    }
    
    
}
