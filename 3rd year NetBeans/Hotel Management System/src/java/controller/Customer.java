
package controller;

import java.util.Date;


public class Customer extends Person{
    
    private String nationality;
    private int accountNum;
    private Date start_Date;
    private Date end_Date;

    public Customer(int ssn,String fname,String lname,String nationality,String sex,int accountNum) {
        super(ssn, fname, lname, sex);
        this.nationality = nationality;
        this.accountNum = accountNum;
        this.start_Date=start_Date;
        this.end_Date=end_Date;
    }

 public Customer() {
    }
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }
    
}