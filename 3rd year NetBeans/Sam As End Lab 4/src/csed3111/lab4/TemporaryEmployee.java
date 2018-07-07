package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */ 
public class TemporaryEmployee extends Employee {

    private int totalHour;

    public TemporaryEmployee(String perName, int perAge, String fieldOfStudy, long phoneNumber, double grossSalary, int totalHour) {
        super(perName, perAge, fieldOfStudy, phoneNumber, grossSalary);
        this.totalHour = totalHour;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public void setTotalHour(int totalHour) {
        this.totalHour = totalHour;
    }

    public double calcTotalPay() {
        double rate;
        double gs = super.getGrossSalary();
        if (gs >= 5000) {
            rate = 0.35;
        } else if (gs >= 4000) {
            rate = 0.25;
        } else if (gs >= 3000) {
            rate = 0.2;
        } else if (gs >= 1500) {
            rate = 0.15;
        } else {
            rate = 0.1;
        }
        double totalPay = totalHour * rate;
        return totalPay;
    }
}
