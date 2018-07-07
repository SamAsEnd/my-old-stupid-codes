package com.apple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderDetail {

    int itemId;
    String itemName;
    int numberOfItem;
    double price;
    private Connection connection;

    public OrderDetail(int itemId, String itemName, int numberOfItem, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.numberOfItem = numberOfItem;
        this.price = price;
    }

    @Override
    public String toString() {
        return (itemName + "[" + numberOfItem + "]");
    }

    public String toSQL(int orderId) {
        return (",(" + itemId + ", " + orderId + ", " + numberOfItem + ")");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OrderDetail)) {
            return false;
        }
        OrderDetail od = (OrderDetail) obj;
        return this.itemId == od.itemId;
    }

    public boolean isMoreThanItem() {

        try {
            connection = Login.connection;
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select itemQuanity from item where itemId = " + itemId);
            result.next();
            int itemQuanity = result.getInt("itemQuanity");

            return ((itemQuanity - numberOfItem) < 0);
        } catch (Exception e) {
            return true;
        }

    }

    public void order() {

        try {
            connection = Login.connection;
            Statement statement = connection.createStatement();
            String s = "update item "
                    + " set itemQuanity = (itemQuanity - " + numberOfItem + ")"
                    + " where itemId = " + itemId;
            System.out.println(s);
            int result = statement.executeUpdate(s);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }

    }
}
