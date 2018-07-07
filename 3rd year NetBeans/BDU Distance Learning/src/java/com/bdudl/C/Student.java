package com.bdudl.C;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String sex;
    private String address;
    private int acadamicStatus;

    public Student() {
    }

    public Student(String firstName, String lastName, String sex, String address, int acadamicStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.address = address;
        this.acadamicStatus = acadamicStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAcadamicStatus() {
        return acadamicStatus;
    }

    public void setAcadamicStatus(int acadamicStatus) {
        this.acadamicStatus = acadamicStatus;
    }

}
