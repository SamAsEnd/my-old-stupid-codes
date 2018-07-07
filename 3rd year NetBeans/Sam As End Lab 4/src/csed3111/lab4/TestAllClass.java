package csed3111.lab4;

/**
 * Samson Endale
 * @author Sam As End
 */
public class TestAllClass {

    public static void main(String[] args) {
        Book bookMemb = new Book("C++", "Sam As End", "123456789012", 99999999999999.99);

        System.out.println("Book Title: " + bookMemb.getBookTitle());
        System.out.println("Book Author: " + bookMemb.getAuthorName());
        System.out.println("Book ISBN: " + bookMemb.getIsbn());
        System.out.println("Book Price: " + bookMemb.getPrice());
        
        System.out.println();
        
        Person person = new Person("Samson Endale", 20, "Computer Scince and Engineering", 921631393);
        
        System.out.println("Perosn Name           : " + person.getPerName());
        System.out.println("Perosn Age            : " + person.getPerAge());
        System.out.println("Perosn Field Of Study : " + person.getFieldOfStudy());
        System.out.println("Perosn Phone Number   : " + person.getPhoneNumber());
        
        System.out.println();
        
        Student student = new Student("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 3.0, 3);
        
        System.out.println("Student Name           : " + student.getPerName());
        System.out.println("Student Age            : " + student.getPerAge());
        System.out.println("Student Field Of Study : " + student.getFieldOfStudy());
        System.out.println("Student Phone Number   : " + student.getPhoneNumber());
        System.out.println("Student Previous GPA   : " + student.getPreviousGPA());
        System.out.println("Student Year Of Study  : " + student.getYearOfStudy());
        
        System.out.println();
        
        Teacher teacher = new Teacher("Dr. Samson Endale", 20, "Computer Scince and Engineering", 921631393, 12, 9999.99);
        
        System.out.println("Teacher Name              : " + teacher.getPerName());
        System.out.println("Teacher Age               : " + teacher.getPerAge());
        System.out.println("Teacher Field Of Study    : " + teacher.getFieldOfStudy());
        System.out.println("Teacher Phone Number      : " + teacher.getPhoneNumber());
        System.out.println("Teacher Total Credit Hour : " + teacher.getTotalCreditHour());
        System.out.println("Teacher Net-Salary        : " + teacher.getNetSalary());
        
        System.out.println();
        
        Employee employee = new Employee("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 99999.99);
        
        System.out.println("Employee Name           : " + employee.getPerName());
        System.out.println("Employee Age            : " + employee.getPerAge());
        System.out.println("Employee Field Of Study : " + employee.getFieldOfStudy());
        System.out.println("Employee Phone Number   : " + employee.getPhoneNumber());
        System.out.println("Employee Gross Salary   : " + employee.getGrossSalary());
        System.out.println("Employee Pension        : " + employee.getPension());
        System.out.println("Employee Net-Salary     : " + employee.getNetSalary());
        
        System.out.println();
        
        PermanentEmployee permanentEmployee = new PermanentEmployee("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 99999.99,5);
        
        System.out.println("PermanentEmployee Name           : " + permanentEmployee.getPerName());
        System.out.println("PermanentEmployee Age            : " + permanentEmployee.getPerAge());
        System.out.println("PermanentEmployee Field Of Study : " + permanentEmployee.getFieldOfStudy());
        System.out.println("PermanentEmployee Phone Number   : " + permanentEmployee.getPhoneNumber());
        System.out.println("PermanentEmployee Gross Salary   : " + permanentEmployee.getGrossSalary());
        System.out.println("PermanentEmployee Pension        : " + permanentEmployee.getPension());
        System.out.println("PermanentEmployee Net-Salary     : " + permanentEmployee.getNetSalary());
        System.out.println("PermanentEmployee Total Income   : " + permanentEmployee.calcTotalIncome());
        
        System.out.println();
        
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee("Samson Endale", 20, "Computer Scince and Engineering", 921631393, 99999.99, 20);
        
        System.out.println("TemporaryEmployee Name           : " + temporaryEmployee.getPerName());
        System.out.println("TemporaryEmployee Age            : " + temporaryEmployee.getPerAge());
        System.out.println("TemporaryEmployee Field Of Study : " + temporaryEmployee.getFieldOfStudy());
        System.out.println("TemporaryEmployee Phone Number   : " + temporaryEmployee.getPhoneNumber());
        System.out.println("TemporaryEmployee Gross Salary   : " + temporaryEmployee.getGrossSalary());
        System.out.println("TemporaryEmployee Pension        : " + temporaryEmployee.getPension());
        System.out.println("TemporaryEmployee Net-Salary     : " + temporaryEmployee.getNetSalary());
        System.out.println("TemporaryEmployee Total Pay      : " + temporaryEmployee.calcTotalPay());
        
    }
    
}
