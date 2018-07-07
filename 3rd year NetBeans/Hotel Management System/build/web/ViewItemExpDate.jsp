<%@page import="controller.EmployeeController"%>
<%@page import="controller.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>expired items Page</title>
    </head>
    <body>
        <h1>Expired Items</h1>
        <table border="1">
            <tr>
                <td>Item Name</td>
                <td>Expired Date</td>
            </tr>
            <%
                ArrayList<Item> expItemList = EmployeeController.getExpItem();

                for (Item i : expItemList) {


            %>
            <tr>
                <td><%=i.getName()%></td>
                <td><%=i.getExpDate()%></td>

            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
