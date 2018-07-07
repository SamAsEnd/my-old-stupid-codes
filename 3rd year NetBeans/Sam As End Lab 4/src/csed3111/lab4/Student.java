package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class Student extends Person {

    private double previousGPA;
    private int yearOfStudy;

    public Student(String perName, int perAge, String fieldOfStudy, long phoneNumber, double previousGPA, int yearOfStudy) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.previousGPA = previousGPA;
        this.yearOfStudy = yearOfStudy;
    }

    public double getPreviousGPA() {
        return previousGPA;
    }

    public void setPreviousGPA(double previousGPA) {
        this.previousGPA = previousGPA;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
}
