package csed3111_lab4;

public class Student extends Person{

    private double previousGPA;
    private int yearOfStudy;

    public Student(double previousGPA, int yearOfStudy, String perName, int perAge, String fieldOfStudy, String phoneNumber) {
        super(perName, perAge, fieldOfStudy, phoneNumber);
        this.previousGPA = previousGPA;
        this.yearOfStudy = yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public double getPreviousGPA() {
        return previousGPA;
    }

    public void setPreviousGPA(double previousGPA) {
        this.previousGPA = previousGPA;
    }
    
}
