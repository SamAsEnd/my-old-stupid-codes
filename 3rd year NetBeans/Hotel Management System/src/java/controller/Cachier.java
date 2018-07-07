

package controller;


public class Cachier extends Employee{
      private String password;

    public Cachier(String password, int ssn, String fname, String lname, String position, String sex, int age, float salary, String username) {
        super(ssn, fname, lname, position, sex, age, salary, username);
        this.password = password;
    }

    public Cachier(String password) {
        this.password = password;
    }

    @Override
    public void setPassword(String password) {
        this.password=password; 
    }

    @Override
    public String getPassword() {
        return password; 
    }

    
    }
      
    

