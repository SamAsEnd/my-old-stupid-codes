package com.bdusn.C;

import com.bdusn.E.UserNotFoundException;
import com.bdusn.M.UserModel;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private int userID;
    private String email;
    private String pass;
    private String firstName;
    private String lastName;
    private char sex;
    private String aboutMe;
    private String religion;
    private LocalDate dateOfBirth;
    private String city;
    private String educationalStatus;
    private String martialStatus;
    private String phoneNumber;
    private LocalDateTime lastActiveTime;
    private int proPicture;
    private int actived;

    //<editor-fold defaultstate="collapsed" desc="getter and setter">
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
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

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
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

    public int getActived() {
        return actived;
    }

    public void setActived(int actived) {
        this.actived = actived;
    }

    //</editor-fold>
    // sign up
    public User(String email, String pass, String firstName, String lastName, char sex, LocalDate dateOfBirth) {
        this.email = email;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    private User(int userID) throws UserNotFoundException {
        this.userID = userID;
        UserModel.loadByID(this);
    }

    private User(String email, String pass) throws UserNotFoundException {
        this.email = email;
        this.pass = pass;
        UserModel.loadByEmailAndPass(this);
    }

    public User() {
    }

    public static User getUserById(int userID) throws UserNotFoundException {
        return new User(userID);
    }

    public static User getUserByEmailAndPass(String email, String pass) throws UserNotFoundException {
        return new User(email, pass);
    }

}
