<%@page import="controller.EmployeeController"%>
<%
    String msg = "";

    if (request.getParameter("OrgID") != null
            && request.getParameter("OrgName") != null
            && request.getParameter("ItemId") != null
            && request.getParameter("Quantity") != null
            && request.getParameter("Price") != null) {

        int OrgID = Integer.parseInt(request.getParameter("OrgID"));
        int ItemId = Integer.parseInt(request.getParameter("ItemId"));
        int Quantity = Integer.parseInt(request.getParameter("Quantity"));
        float Price = Float.parseFloat(request.getParameter("Price"));
        boolean store = EmployeeController.storeItem(OrgID,
                request.getParameter("OrgName"), ItemId,
                Quantity, Price);
        if (store) {
            msg = "<span style='color: green'>Successfully Stored!!</span>";
        } else {
            msg = "<span style='color: red'>Not stored!!</span>";
        }
    }%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store keeper Page</title>
    </head>
    <body>
    <center><h1>Store Item</h1></center>
    <form action="" method="post">
        <table style="margin: 50px auto; border: 1px solid black; padding: 5px">
            <tr>
                <td colspan="2" style="text-align: center">
                    <span style="color: red"><%=msg%></span>
                </td>
            </tr>
            <tr>
                <td>
                    Organization ID:
                </td>
                <td>
                    <input type="number" name="OrgID" />
                </td>
            </tr>
            <tr>
                <td>
                    Organization Name:
                </td>
                <td>
                    <input type="text" name="OrgName" />
                </td>
            </tr>
            <tr>
                <td>
                    Item ID:
                </td>
                <td>
                    <input type="number" name="ItemId" />
                </td>
            </tr>
            <tr>
                <td>
                    Quantity:
                </td>
                <td>
                    <input type="number" name="Quantity" />
                </td>
            </tr>
            <tr>
                <td>
                    Price:
                </td>
                <td>
                    <input type="text" name="Price" />
                </td>
            </tr>
            <hr></hr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="save"/>
                    <input type="Reset" value="Reset"/>
                </td>
            </tr>
            </body>
            </html>
