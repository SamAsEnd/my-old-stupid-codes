 package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class TeacherTest {
    public static void main(String[] args) { 
        Teacher teacher = new Teacher("Dr. Samson Endale", 20, "Computer Scince and Engineering", 921631393, 12, 9999.99);
        
        System.out.println("Teacher Name              : " + teacher.getPerName());
        System.out.println("Teacher Age               : " + teacher.getPerAge());
        System.out.println("Teacher Field Of Study    : " + teacher.getFieldOfStudy());
        System.out.println("Teacher Phone Number      : " + teacher.getPhoneNumber());
        System.out.println("Teacher Total Credit Hour : " + teacher.getTotalCreditHour());
        System.out.println("Teacher Net-Salary        : " + teacher.getNetSalary());
        
    }
}
