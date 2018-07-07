package csed3111_lab4;

public class TestAllClass {

    public static void main(String[] args) {
        Person person = new Person("Netsi", 23, "EED", "0912457878");
        System.out.println("Person Name        : " + person.getPerName());
        System.out.println("Person Age         : " + person.getPerAge());
        System.out.println("Person FieldOfStudy: " + person.getFieldOfStudy());
        System.out.println("Person PhoneNumber : " + person.getPhoneNumber());
        
        System.out.println();
        
        Student student = new Student(3.00, 3, "Netsi", 23, "EED", "0912457878");
        System.out.println("Student Name        : " + student.getPerName());
        System.out.println("Student Age         : " + student.getPerAge());
        System.out.println("Student FieldOfStudy: " + student.getFieldOfStudy());
        System.out.println("Student PhoneNumber : " + student.getPhoneNumber());
        
        System.out.println("Student PreviousGPA : " + student.getPreviousGPA());
        System.out.println("Student YearOfStudy : " + student.getYearOfStudy());
        
        System.out.println();
        
        Teacher teacher = new Teacher(20, 5000, "Netsi", 23, "EED", "0912457878");
        System.out.println("Teacher Name            : " + teacher.getPerName());
        System.out.println("Teacher Age             : " + teacher.getPerAge());
        System.out.println("Teacher FieldOfStudy    : " + teacher.getFieldOfStudy());
        System.out.println("Teacher PhoneNumber     : " + teacher.getPhoneNumber());
        
        System.out.println("Teacher TotalCreditHour : " + teacher.getTotalCreditHour());
        System.out.println("Teacher NetSalary       : " + teacher.getNetSalary());
        
        System.out.println();
        
        Employee employee = new Employee(5000, "Netsi", 23, "EED", "0912457878");
        System.out.println("Employee Name            : " + employee.getPerName());
        System.out.println("Employee Age             : " + employee.getPerAge());
        System.out.println("Employee FieldOfStudy    : " + employee.getFieldOfStudy());
        System.out.println("Employee PhoneNumber     : " + employee.getPhoneNumber());
        
        System.out.println("Employee GrossSalary     : " + employee.getGrossSalary());
        
        System.out.println("Employee Pension         : " + employee.getPension());
        System.out.println("Employee NetSalary       : " + employee.getNetSalary());
        
        System.out.println();
        
        PermanentEmployee permanentEmployee = new PermanentEmployee(12, 5000, "Netsi", 23, "EED", "0912457878");
        System.out.println("PermanentEmployee Name        : " + permanentEmployee.getPerName());
        System.out.println("PermanentEmployee Age         : " + permanentEmployee.getPerAge());
        System.out.println("PermanentEmployee FieldOfStudy: " + permanentEmployee.getFieldOfStudy());
        System.out.println("PermanentEmployee PhoneNumber : " + permanentEmployee.getPhoneNumber());
        
        System.out.println("PermanentEmployee GrossSalary : " + permanentEmployee.getGrossSalary());
        
        System.out.println("PermanentEmployee Pension     : " + permanentEmployee.getPension());
        System.out.println("PermanentEmployee NetSalary   : " + permanentEmployee.getNetSalary());
        
        System.out.println("PermanentEmployee ToatlIncome   : " + permanentEmployee.calcTotalIncome());
        
        System.out.println();
        
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(12, 5000, "Netsi", 23, "EED", "0912457878");
        System.out.println("TemporaryEmployee Name        : " + temporaryEmployee.getPerName());
        System.out.println("TemporaryEmployee Age         : " + temporaryEmployee.getPerAge());
        System.out.println("TemporaryEmployee FieldOfStudy: " + temporaryEmployee.getFieldOfStudy());
        System.out.println("TemporaryEmployee PhoneNumber : " + temporaryEmployee.getPhoneNumber());
        
        System.out.println("TemporaryEmployee GrossSalary : " + temporaryEmployee.getGrossSalary());
        
        System.out.println("TemporaryEmployee Pension     : " + temporaryEmployee.getPension());
        System.out.println("TemporaryEmployee NetSalary   : " + temporaryEmployee.getNetSalary());
        
        System.out.println("TemporaryEmployee ToatlPay   : " + temporaryEmployee.calcTotalPay());
        
    }
}
