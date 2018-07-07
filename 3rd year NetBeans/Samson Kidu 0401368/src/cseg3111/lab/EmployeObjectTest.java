package cseg3111.lab;

import cseg3111.lab.exercises.Employe;
/*
 * SAmson Kidu 0401368
 */
public class EmployeObjectTest {

    public static void main(String[] args) {
        Employe empObject = new Employe();
        System.out.println("Employe name: " + empObject.empName);
        System.out.println("Employe ID: " + empObject.empId);
        System.out.println("Employe Departement: " + empObject.empDepartment);
    }

}
