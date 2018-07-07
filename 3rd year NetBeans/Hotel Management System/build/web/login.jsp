<%@page import="controller.Employee"%>
<%@page import="controller.EmployeeController"%>
<%
    String errorMsg = "";

    if (request.getParameter("username") != null && request.getParameter("password") != null) {

        Employee employee = EmployeeController.login(request.getParameter("username"), request.getParameter("password"));

        if (employee != null) {
            session.setAttribute("ssn", employee.getSsn());
            String position = employee.getPosition();
            if (position == "manager") {
                response.sendRedirect("manager.jsp");
            } else if (position == "reception") {
                response.sendRedirect("Reception.jsp");
            } else if (position == "store keeper") {
                response.sendRedirect("StoreKeeper.jsp");
            } else {
                response.sendRedirect("Staff.jsp");
            }
        } else {
            errorMsg = "Invalid Username and password";
        }

    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="General.css" type="text/css" media="screen">
    </head>
    <body>
        <div id="container">
            <div id="position1">
                <div id="header" title="SummerLandHotelManagmentSystem" >
                    <object  class="leftswf" id="obj1" border="0" height="63" width="50">
                        <embed src="image/sum.jpg"   height="120" width="155"></object>

                    <object  class="rightswf" id="obj1" border="0" height="63" width="100">
                        <embed src="image/sum.jpg"   height="120" width="100"></object>
                    SummerLand Hotel Management</br>
                    System


                </div>
                <div id="mainnav">
                    <ul>
                        <li><a href="GeneralNave.jsp">Home</a></li>
                        <li><a href="#"><small>Reservation</small></a>
                            <ul>
                                <li><a href = "Reservation.jsp"> Room and Hall</a> </li>
                                <li><a href = ""> Restaurant </a> </li>
                                <li><a href = ""> Change Reservation </a> </li>
                            </ul>
                        </li>
                        <li><a href="Registration.jsp">Registration</a></li>

                        <li><a href="#">View</a>
                            <ul>
                                <li><a href = ""> Room </a> </li>
                                <li><a href = ""> Service </a> </li>
                                <li><a href = ""> Hall </a> </li>
                                <li><a href = ""> Item </a> </li>
                            </ul>
                        </li>
                        <li><a href="GeneralNave.jsp">About us</a></li>
                    </ul>
                </div>
            </div>
            <div id="menu">
                <h3>
                    Services
                </h3>
                <ul>
                    <li><a href="GeneralNave.jsp">Car </a></li>
                    <li><a href="GeneralNave.jsp">Gass station</a></li>
                    <li><a href="GeneralNave.jsp">Sweemming</a></li>
                    <li><a href="GeneralNave.jsp">Parking</a></li>
                </ul>
                <h3>
                    Information About Rooms
                </h3>
                <ul>
                    <li><a href="GeneralNave.jsp">Rooms</a></li>

                </ul>
                <h3>
                    Information About Halls
                </h3>
                <ul>
                    <li><a href="GeneralNave.jsp">Hall</a></li>


                </ul>
            </div>
            <form action="login.jsp" method="post" style="top: 200px; position: absolute">
                <table style="margin: 50px auto; border: 1px solid black; padding: 5px">
                    <tr>
                        <td colspan="2" style="text-align: center">
                            <h2>Login</h2>
                            <span style="color: red"><%=errorMsg%></span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Username
                        </td>
                        <td>
                            <input type="text" name="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Password
                        </td>
                        <td>
                            <input type="password" name="password" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Login"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
