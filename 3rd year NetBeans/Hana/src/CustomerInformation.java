
import java.util.Date;

public class CustomerInformation {
    
    private String name;
    private char sex;   
    private String birthDate; 

    public CustomerInformation() {
    }

    public CustomerInformation(String name, char sex, String birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }
    
    public String login() {
        return "Reme use s password";
    }
    
    public String request() {
        return "ed ed cedc edc edm cde";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
