package controller;

import java.sql.Date;
import java.util.ArrayList;
import model.CustomerModel;

public class CustomerController {

    public static boolean registerCustomer(int ssn, String fname, String lname, String nationality, String sex, int accountNum) {
        Customer customer = new Customer(ssn, fname, lname, nationality, sex, accountNum);
        return CustomerModel.regiteredCustomer(customer);
    }

    public static ArrayList<Service> getServices() {
        ArrayList<Service> services = CustomerModel.selectAllService();
        return services;
    }

    public static ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = CustomerModel.selectAllRooms();
        return rooms;
    }

    public static ArrayList<Hall> getHalls() {
        ArrayList<Hall> halls = CustomerModel.selectAllHalls();
        return halls;
    }

    public static ArrayList<Item> getItems() {
        ArrayList<Item> items = CustomerModel.selectAllItems();
        return items;
    }

    public static boolean reserveCustomer(int Cssn, int BNo, int roomNum, int hallNum, Date start_Date, Date end_Date) {
        return CustomerModel.reservedCustomer(Cssn, BNo, roomNum, hallNum, start_Date, end_Date);
    }

    public static boolean CustomerAddress(int Cssn, String homeTown, int phoneNumber, String email) {
        return CustomerModel.reservedCustomerAddress(Cssn, homeTown, phoneNumber, email);
    }

    public static float getItemPrice(int ssn) {
        return CustomerModel.getItemPrice(ssn);
    }

    public static float getRoomPrice(int ssn) {
        return CustomerModel.getRoomPrice(ssn);
    }

    public static float getHallPrice(int ssn) {
        return CustomerModel.getHallPrice(ssn);
    }

}
