package cseg3111.lab;

/*
 * Yonas getenet 2135/03
 */

import cseg3111.lab.exercises.Employee;

public class EmployeeObjectTest {

    public static void main(String args[]) {
        Employee empobject = new Employee();
        System.out.println("empName: " + empobject.empName);
        System.out.println("empId: " + empobject.empId);
        System.out.println("empDepartment: " + empobject.empDepartemet);
    }
}
