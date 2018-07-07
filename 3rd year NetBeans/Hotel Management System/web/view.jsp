<%@page import="controller.Hall"%>
<%@page import="controller.Item"%>
<%@page import="controller.Room"%>
<%@page import="controller.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.CustomerController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>viewing services Page</title>
    </head>
    <body >
        <h1>Types Of Services With There cost</h1>
        <table border="1">
            <tr>
                <td>Type</td>
                <td>Price</td>
            </tr>
            <%
                ArrayList<Service> serviceList = CustomerController.getServices();

                for (Service s : serviceList) {
                //for(int i=o;i<9;i++)

            %>
            <tr>
                <td><%=s.getType()%></td>
                <td><%=s.getPrice()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <h1>Available Rooms With There appropriate cost</h1>
        <table border="1">
            <tr>
                <td>Room Number</td>
                <td>Price</td>
                <td>Floor Number</td>
            </tr>
            <%
                ArrayList<Room> roomList = CustomerController.getRooms();

                for (Room r : roomList) {


            %>
            <tr>
                <td><%=r.getRoomNumber()%></td>
                <td><%=r.getPrice()%></td>
                <td><%=r.getFloorNum()%></td>
            </tr>
            <%
                }
            %>
        </table>
        <h1>Types Items With Their appropriate cost</h1>
        <table border="1">
            <tr>
                <td>Item Name</td>
                <td>Price</td>

            </tr>
            <%
                ArrayList<Item> itemList = CustomerController.getItems();

                for (Item i : itemList) {


            %>
            <tr>
                <td><%=i.getName()%></td>
                <td><%=i.getPrice()%></td>

            </tr>
            <%
                }
            %>
        </table>
        <h1>Available Halls</h1>
        <table border="1">
            <tr>
                <td>Hall Name</td>
                <td>Floor Number</td>
                <td>Price</td>
                <td>Size</td>

            </tr>
            <%
                ArrayList<Hall> hallList = CustomerController.getHalls();

                for (Hall h : hallList) {


            %>
            <tr>
                <td><%=h.getHallNum()%></td>
                <td><%=h.getFloorNum()%></td>
                <td><%=h.getPrice()%></td>
                <td><%=h.getSize()%></td>

            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
