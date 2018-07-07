package csed3111_lab4;

public class TemporaryEmployee extends Employee {

    private int totalHour;

    public TemporaryEmployee(int totalHour, double grossSalary, String perName, int perAge, String fieldOfStudy, String phoneNumber) {
        super(grossSalary, perName, perAge, fieldOfStudy, phoneNumber);
        this.totalHour = totalHour;
    }

    public double calcTotalPay() {
        double rate;
        if (getGrossSalary() >= 5000) {
            rate = 0.35;
        } else if (getGrossSalary() >= 4000) {
            rate = 0.25;
        } else if (getGrossSalary() >= 3000) {
            rate = 0.20;
        } else if (getGrossSalary() >= 1500) {
            rate = 0.15;
        } else {
            rate = 0.1;
        }
        double totalPay = totalHour * rate;
        return totalPay;
    }

}
