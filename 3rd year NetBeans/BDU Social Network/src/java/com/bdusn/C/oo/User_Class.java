package com.bdusn.C.oo;

import com.bdusn.M.UserModel;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User_Class implements Serializable {

    private int userID;
    private String email;
    private String pass;
    private String firstName;
    private String lastName;
    private String sex;
    private String aboutMe;
    private String religion;
    private LocalDate dateOfBirth;
    private String city;
    private String educationalStatus;
    private String martialStat;
    private String phoneNumber;
    private LocalDateTime lastActiveTime;
    private int proPicture;
    private boolean activated;

    public User_Class(int userID) {
        this.userID = userID;
    }

    //<editor-fold defaultstate="collapsed" desc="getter and setters">
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getMartialStat() {
        return martialStat;
    }

    public void setMartialStat(String martialStat) {
        this.martialStat = martialStat;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(LocalDateTime lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public int getProPicture() {
        return proPicture;
    }

    public void setProPicture(int proPicture) {
        this.proPicture = proPicture;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    //</editor-fold>

    public void load() {
        UserModel.load(this);
    }

}
