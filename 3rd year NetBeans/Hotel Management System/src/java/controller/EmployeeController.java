package controller;

import java.util.ArrayList;
import model.EmployeeModel;

public class EmployeeController {

    public static Employee login(String username, String password) {
        Employee employee = new Employee();
        employee.setUsername(username);
        employee.setPassword(password);

        if (EmployeeModel.validateUsernameAndPassword(employee)) {
            return employee;
        } else {
            return null;
        }
    }

    public static ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = EmployeeModel.selectAllEmployee();
        return employees;
    }

    public static boolean fireEmployee(int ssn) {
        Employee employee = new Employee();
        employee.setSsn(ssn);

        return EmployeeModel.deleteEmployeeById(employee);
    }

    public static boolean hireEmployee(int ssn, String fname, String lname, String position, String sex, int age, float salary, String username) {
        Employee employee = new Employee(ssn, fname, lname, position, sex, age, salary, username);

        return EmployeeModel.insertEmployee(employee);
    }
    /*  public static ArrayList<Customer> getRoomReservedCustomers() {
     ArrayList<Customer> customers = EmployeeModel.selectRoomreservedCustomer();
     return customers;
     }*/

    public static boolean storeItem(int orgId, String orgName, int itemId, int Quantity, float price) {
        Supplier supplier = new Supplier(orgId, orgName, itemId, Quantity, price);
        return EmployeeModel.insertItem(supplier);
    }

    public static ArrayList<Item> getExpItem() {
        ArrayList<Item> expItems = EmployeeModel.selectExpiredItem();
        return expItems;
    }

}
