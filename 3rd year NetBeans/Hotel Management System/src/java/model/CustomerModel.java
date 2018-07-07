package model;

import controller.Customer;
import controller.Hall;
import controller.Item;
import controller.Room;
import controller.Service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class CustomerModel {

    public static boolean regiteredCustomer(Customer c) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement register = connection.prepareStatement("INSERT INTO dbo.CUSTOMER "
                    + "	VALUES (?, ?, ?, ?, ?,?) ");
            register.setInt(1, c.getSsn());
            register.setString(2, c.getFname());
            register.setString(3, c.getLname());
            register.setString(4, c.getNationality());
            register.setString(5, c.getSex());
            register.setInt(6, c.getAccountNum());
            int rows = register.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static ArrayList<Service> selectAllService() {
        ArrayList<Service> list = new ArrayList<Service>();
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT Type,Price FROM SERVICE");
            ResultSet resultSet = select.executeQuery();

            while (resultSet.next()) {
                Service service = new Service();
                service.setType(resultSet.getString("type"));
                service.setPrice(resultSet.getFloat("price"));
                list.add(service);
            }
            return list;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ArrayList<Room> selectAllRooms() {
        ArrayList<Room> list = new ArrayList<Room>();
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT * FROM Room");
            ResultSet resultSet = select.executeQuery();

            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomNumber(resultSet.getInt("roomNumber"));
                room.setPrice(resultSet.getFloat("price"));
                room.setFloorNum(resultSet.getString("floorNum"));
                list.add(room);
            }
            return list;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ArrayList<Hall> selectAllHalls() {
        ArrayList<Hall> list = new ArrayList<Hall>();
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT * FROM HALL");
            ResultSet resultSet = select.executeQuery();

            while (resultSet.next()) {
                Hall hall = new Hall();
                hall.setHallNum(resultSet.getInt("hallNum"));
                hall.setFloorNum(resultSet.getString("floorNum"));
                hall.setPrice(resultSet.getFloat("price"));
                hall.setSize(resultSet.getString("size"));
                list.add(hall);
            }
            return list;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static ArrayList<Item> selectAllItems() {
        ArrayList<Item> list = new ArrayList<Item>();
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement select = connection.prepareStatement("SELECT Name,price FROM ITEM");
            ResultSet resultSet = select.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getFloat("price"));
                list.add(item);
            }
            return list;
        } catch (SQLException ex) {
        }
        return null;
    }

    public static boolean reservedCustomer(int Cssn, int BNo, int roomNum, int hallNum, Date start_Date, Date end_Date) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement reserve = connection.prepareStatement("INSERT INTO dbo.RESERVATION "
                    + "(CSSN,BNo,HallNo,RoomNum,Start_Date,End_Date)"
                    + "	VALUES (?, ?, ?, ?, ?,?) ");
            reserve.setInt(1, Cssn);
            reserve.setInt(2, BNo);

            if (hallNum == 0) {
                reserve.setNull(3, Types.INTEGER);
            } else {
                reserve.setInt(3, hallNum);
            }

            if (roomNum == 0) {
                reserve.setNull(4, Types.INTEGER);
            } else {
                reserve.setInt(4, roomNum);

            }
            reserve.setDate(5, start_Date);
            reserve.setDate(6, end_Date);
            int rows = reserve.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static float getItemPrice(int ssn) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement price = connection.prepareStatement("SELECT SUM(i.Price * r.Quantity) bill\n"
                    + "FROM RESERVATION r,ITEM i\n"
                    + "WHERE r.ItemId = i.ItemID \n"
                    + "AND r.CSSN = ?");
            price.setInt(1, ssn);
            ResultSet rslt = price.executeQuery();
            rslt.next();
            return rslt.getFloat("bill");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static float getRoomPrice(int ssn) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement price = connection.prepareStatement("SELECT SUM(rm.Price * (day(r.End_Date) - day(r.Start_Date))) bill\n"
                    + "     FROM RESERVATION r,ROOM rm\n"
                    + "     WHERE r.RoomNum = rm.RoomNumber\n"
                    + "     AND r.CSSN = ?");
            price.setInt(1, ssn);
            ResultSet rslt = price.executeQuery();
            rslt.next();
            return rslt.getFloat("bill");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static float getHallPrice(int ssn) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement price = connection.prepareStatement("SELECT SUM(h.Price * (day(r.End_Date) - day(r.Start_Date))) bill\n"
                    + "     FROM RESERVATION r,HALL h\n"
                    + "     WHERE r.HallNo = h.HallNo\n"
                    + "     AND r.CSSN = ?");
            price.setInt(1, ssn);
            ResultSet rslt = price.executeQuery();
            rslt.next();
            return rslt.getFloat("bill");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static boolean reservedCustomerAddress(int Cssn, String homeTown, int phoneNumber, String email) {
        try {
            DatabaseConnecter databaseConnecter = new DatabaseConnecter();
            Connection connection = databaseConnecter.getConnection();
            PreparedStatement reserve = connection.prepareStatement("INSERT INTO dbo.CUST_ADDRESS "
                    + "	VALUES (?, ?, ?, ?) ");
            reserve.setInt(1, Cssn);
            reserve.setString(2, homeTown);
            reserve.setInt(3, phoneNumber);
            reserve.setString(4, email);
            int rows = reserve.executeUpdate();
            return rows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        reservedCustomer(1, 2, 21, 0, null, null);
    }
}
