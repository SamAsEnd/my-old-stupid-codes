package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class StudentTest {
    public static void main(String[] args) { 
        Student student = new Student("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 3.0, 3);
        
        System.out.println("Student Name           : " + student.getPerName());
        System.out.println("Student Age            : " + student.getPerAge());
        System.out.println("Student Field Of Study : " + student.getFieldOfStudy());
        System.out.println("Student Phone Number   : " + student.getPhoneNumber());
        System.out.println("Student Previous GPA   : " + student.getPreviousGPA());
        System.out.println("Student Year Of Study  : " + student.getYearOfStudy());
        
    }
}
