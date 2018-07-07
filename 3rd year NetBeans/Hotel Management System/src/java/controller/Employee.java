package controller;

public class Employee extends Person {
    private String position;
    private String username;
    private String password;
    private int age;
    private float salary;

    public Employee(int ssn, String fname, String lname, String position, String sex, int age, float salary, String username) {
     super(ssn,fname,lname,sex);
        this.position = position;
        this.username = username;
        // default password for new employee
        this.password = "hms";
    }

    
    
    public Employee() {
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
       public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }  
}
