/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author Sam As End
 */
public class Contact {

    private int id;
    private String firstName;
    private String lastName;
    private char sex;
    private String officeNumber;
    private String mobileNumber;
    private String homeNumber;
    private String email;
    private String note;

    public Contact(int id, String firstName, String lastName, char sex, String officeNumber, String mobileNumber, String homeNumber, String email, String note) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.officeNumber = officeNumber;
        this.mobileNumber = mobileNumber;
        this.homeNumber = homeNumber;
        this.email = email;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Contact{" + "firstName=" + firstName + ", lastName=" + lastName + ", sex=" + sex + ", officeNumber=" + officeNumber + ", mobileNumber=" + mobileNumber + ", homeNumber=" + homeNumber + ", email=" + email + ", note=" + note + '}';
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}
