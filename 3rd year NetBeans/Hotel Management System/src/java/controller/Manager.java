
package controller;

public class Manager extends Employee{
    private String password;

    public Manager(int ssn, String fname, String lname, String position, String sex, int age, float salary, String username,String password) {
     super(ssn,fname,lname,sex,position,age,salary,username);
     this.password=password;
    }
    public Manager(){
        
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }  
}
    
