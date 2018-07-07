<%@page import="controller.CustomerController"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String msg = "";

    if (request.getParameter("ssn") != null
            && request.getParameter("roomNum") != null
            && request.getParameter("hallNum") != null && request.getParameter("BNo") != null) {

        int day1 = Integer.parseInt(request.getParameter("day1"));
        int month1 = Integer.parseInt(request.getParameter("month1"));
        int year1 = Integer.parseInt(request.getParameter("year1"));

        Date d1 = new Date(year1 - 1900, month1, day1);
        int day2 = Integer.parseInt(request.getParameter("day2"));
        int month2 = Integer.parseInt(request.getParameter("month2"));
        int year2 = Integer.parseInt(request.getParameter("year2"));

        Date d2 = new Date(year2 - 1900, month2, day2);
        int ssn = Integer.parseInt(request.getParameter("ssn"));
        int roomNum = Integer.parseInt(request.getParameter("roomNum"));
        int hallNum = Integer.parseInt(request.getParameter("hallNum"));
        int BNo = Integer.parseInt(request.getParameter("BNo"));
        boolean inserted = CustomerController.reserveCustomer(ssn, BNo,
                roomNum, hallNum, d1, d2);

        if (inserted) {
            msg = "<span style='color: green'>Successfully Reserved!!</span>";
        } else {
            msg = "<span style='color: red'>Failed on Reserved!!</span>";
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>customer reservation page</title>
    </head>
    <body>
    <center>   <h1>Welcome To Our Hotel</h1></center>
    <form action="Reservation.jsp" method="post">
        <table style="margin: 50px auto; border: 1px solid black; padding: 5px">
            <tr>
                <td colspan="2" style="text-align: center">
                    <h2>Customers Reservation Form</h2>
                    <%=msg%>
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
                    Branch Number:
                </td>
                <td>
                    <input type="number" name="BNo" />
                </td>
            </tr>
            <tr>
                <td>
                    Room Number:
                </td>
                <td>
                    <select  name="roomNum" >
                        <option value="0">None</option>
                        <%//
                            for (int i = 1; i <= 100; i++) {
                                out.print("<option value='" + i + "'>" + i + "</option>");
                            }
                        %>

                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    Start_Date:
                </td>
                <td>
                    <select  name="year1" >
                        <%
                            int length = new java.util.Date().getYear() + 1900;
                            for (int y1 = 2006; y1 <= length; y1++) {
                                out.print("<option value='" + y1 + "'>" + y1 + "</option>");
                            }
                        %>
                    </select>
                    <select name="month1">
                        <%
                            for (int m = 1; m <= 12; m++) {
                                out.print("<option value='" + m + "'>" + m + "</option>");
                            }
                        %>
                    </select>

                    <select name="day1">
                        <%
                            for (int d = 1; d <= 31; d++) {
                                out.print("<option value='" + d + "'>" + d + "</option>");
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    End_Date:
                </td>
                <td>
                    <select  name="year2" >
                        <%
                            int len = new java.util.Date().getYear() + 1900;
                            for (int y2 = 2006; y2 <= len; y2++) {
                                out.print("<option value='" + y2 + "'>" + y2 + "</option>");
                            }
                        %>
                    </select>
                    <select name="month2">
                        <%
                            for (int m = 1; m <= 12; m++) {
                                out.print("<option value='" + m + "'>" + m + "</option>");
                            }
                        %>
                    </select>

                    <select name="day2">
                        <%
                            for (int d = 1; d <= 31; d++) {
                                out.print("<option value='" + d + "'>" + d + "</option>");
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    Hall Number:
                </td>
                <td>
                    <select  name="hallNum" >
                        <option value="0">None</option>
                        <%
                            for (int i = 1; i <= 10; i++) {
                                out.print("<option value='" + i + "'>" + i + "</option>");
                            }
                        %>
                    </select>
                </td>
            </tr>
            <hr></hr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="submit"/>
                    <input type="Reset" value="Reset"/>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
