package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class Person {

    private String perName;
    private int perAge;
    private String fieldOfStudy;
    private long phoneNumber;

    public Person(String perName, int perAge, String fieldOfStudy, long phoneNumber) {
        this.perName = perName;
        this.perAge = perAge;
        this.fieldOfStudy = fieldOfStudy;
        this.phoneNumber = phoneNumber;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public int getPerAge() {
        return perAge;
    }

    public void setPerAge(int perAge) {
        this.perAge = perAge;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
