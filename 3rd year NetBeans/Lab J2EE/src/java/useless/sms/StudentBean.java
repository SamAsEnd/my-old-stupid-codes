package useless.sms;

public class StudentBean {

    private String firstName, secondName, department, id;
    private char sex;
    private int age;
    private double gpa;

    public StudentBean(String id, String fName, String sName, String dept) {
        setId(id);
        setFirstName(fName);
        setSecondName(sName);
        setDepartment(dept);
    }

    public StudentBean(String id, String fName, String sName, String dept, char sex, int age, double gpa) {
        this(id, fName, sName, dept);
        setSex(sex);
        setAge(age);
        setGpa(gpa);
    }

    //getters
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return firstName;
    }

    public String getDepartment() {
        return firstName;
    }

    public String getId() {
        return firstName;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    //setters
    public void setFirstName(String fName) {
        firstName = fName;
    }

    public void setSecondName(String sName) {
        secondName = sName;
    }

    public void setDepartment(String dept) {
        department = dept;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
