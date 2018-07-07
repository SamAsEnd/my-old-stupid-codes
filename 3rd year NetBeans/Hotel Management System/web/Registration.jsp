<%@page import="java.util.Map"%>
<%@page import="controller.*"%>
<%
    String msg = "";

    if (request.getParameter("ssn") != null
            && request.getParameter("fname") != null
            && request.getParameter("lname") != null
            && request.getParameter("sex") != null
            && request.getParameter("nationality") != null
            && request.getParameter("accountNum") != null && request.getParameter("homeTown") != null
            && request.getParameter("phoneNumber") != null && request.getParameter("email") != null) {

        int ssn = Integer.parseInt(request.getParameter("ssn"));
        int accountNum = Integer.parseInt(request.getParameter("accountNum"));
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        boolean register = CustomerController.registerCustomer(ssn,
                request.getParameter("fname"), request.getParameter("lname"),
                request.getParameter("nationality"), request.getParameter("sex"), accountNum);
        register = CustomerController.CustomerAddress(ssn, request.getParameter("homeTown"), phoneNumber, request.getParameter("email"));
        if (register) {
            msg = "<span style='color: green'>Successfully Registered!!</span>";
        } else {
            msg = "<span style='color: red'>No Registration takes place!!</span>";
        }
    }%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation Page</title>
    </head>
    <body>
        <form action="Registration.jsp" method="post">
            <table style="margin: 50px auto; border: 1px solid black; padding: 5px">
                <tr>
                    <td colspan="2" style="text-align: center">
                        <h2>Customer Registration Form</h2>
                        <span style="color: red"><%=msg%></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        SSN:
                    </td>
                    <td>
                        <input type="number" name="ssn" />
                    </td>
                </tr>
                <tr>
                    <td>
                        First Name:
                    </td>
                    <td>
                        <input type="text" name="fname" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Last Name:
                    </td>
                    <td>
                        <input type="text" name="lname" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Nationality:
                    </td>
                    <td>
                        <input type="text" name="nationality" />
                    </td>
                </tr>
                <tr>
                    <td>
                        sex:
                    </td>
                    <td>
                        <select name="sex">
                            <option value="M">male</option>
                            <option value="F">female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        Account Number:
                    </td>
                    <td>
                        <input type="number" name="accountNum" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Address:
                    </td>
                <tr>
                    <td>
                        Home Town:
                    </td>
                    <td>
                        <input type="text" name="homeTown" />
                    </td>
                    <td>
                        Phone Number:
                    </td>
                    <td>
                        <input type="number" name="phoneNumber" />
                    </td>
                    <td>
                        Email:
                    </td>
                    <td>
                        <input type="text" name="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="submit"/>
                        <input type="Reset" value="Reset"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
