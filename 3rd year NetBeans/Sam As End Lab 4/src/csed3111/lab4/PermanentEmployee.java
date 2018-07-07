package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class PermanentEmployee extends Employee {

    private int overTimePerWeek;

    public PermanentEmployee(String perName, int perAge, String fieldOfStudy, long phoneNumber, double grossSalary, int overTimePerWeek) {
        super(perName, perAge, fieldOfStudy, phoneNumber, grossSalary);
        this.overTimePerWeek = overTimePerWeek;
    }

    public double calcTotalIncome() {
        double totalIncome = overTimePerWeek * 80 + super.getNetSalary();
        return totalIncome;
    }

    public int getOverTimePerWeek() {
        return overTimePerWeek;
    }

    public void setOverTimePerWeek(int overTimePerWeek) {
        this.overTimePerWeek = overTimePerWeek;
    }
}
