package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */ 
public class PersonTest {
    public static void main(String[] args) { 
        Person person = new Person("Samson Endale", 20, "Computer Scince and Engineering", 921631393);
        
        System.out.println("Perosn Name           : " + person.getPerName());
        System.out.println("Perosn Age            : " + person.getPerAge());
        System.out.println("Perosn Field Of Study : " + person.getFieldOfStudy());
        System.out.println("Perosn Phone Number   : " + person.getPhoneNumber());
        
    }
}
