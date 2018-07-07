
package controller;


public class Person {
    private int ssn;
    private String fname;
    private String lname;
    private String sex;

    public Person(int ssn, String fname, String lname,  String sex) {
        this.ssn = ssn;
        this.fname = fname;
        this.lname = lname;
        this.sex = sex;
    }
    public Person() {
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }  
}
