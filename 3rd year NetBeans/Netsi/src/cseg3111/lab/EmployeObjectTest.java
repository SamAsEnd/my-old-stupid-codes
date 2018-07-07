package cseg3111.lab;
// Question 7
/*
 * Netsanet Hailu
 * ID 0401282
 */

import cseg3111.lab.exercises.Employe;

public class EmployeObjectTest {

    public static void main(String[] args) {
        Employe empObject = new Employe();
        System.out.println("Employe name: " + empObject.empName);
        System.out.println("Employe ID: " + empObject.empId);
        System.out.println("Employe Departement: " + empObject.empDepartment);
    }
    /*  Question 8
     * 
     * variable empObject might not have been initialized
	at cseg3111.lab.EmployeObjectTest.main(EmployeObjectTest.java:9)
     */
}
