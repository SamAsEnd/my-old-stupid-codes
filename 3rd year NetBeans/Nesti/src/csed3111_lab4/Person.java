package csed3111_lab4;

public class Person {
    
    private String perName;
    private int perAge;
    private String fieldOfStudy;
    private String phoneNumber;

    public Person(String perName, int perAge, String fieldOfStudy, String phoneNumber) {
        this.perName = perName;
        this.perAge = perAge;
        this.fieldOfStudy = fieldOfStudy;
        this.phoneNumber = phoneNumber;
    }

    public String getPerName() {
        return perName;
    }

    public int getPerAge() {
        return perAge;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
}
