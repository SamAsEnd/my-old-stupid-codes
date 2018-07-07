package csed3111_lab4;

public class Person {
    
    private String perName;
    private String perAge;
    private String fieldOfStudy;
    private long phoneNumber;

    public Person(String perName, String perAge, String fieldOfStudy, long phoneNumber) {
        this.perName = perName;
        this.perAge = perAge;
        this.fieldOfStudy = fieldOfStudy;
        this.phoneNumber = phoneNumber;
    }

    public String getPerName() {
        return perName;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getPerAge() {
        return perAge;
    }
   
}
