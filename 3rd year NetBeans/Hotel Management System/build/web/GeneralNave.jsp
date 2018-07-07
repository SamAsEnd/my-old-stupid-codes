<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
    "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <title>SummerLandHotel home page</title>
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
                        <li><a href="login.jsp">Login</a></li>

                    </ul>
                </div>
            </div>
            <div id="menu">
                <h3>
                    Services
                </h3>
                <ul>
                    <li><a href="GeneralNave.jsp">Car </a></li>
                    <li><a href="GeneralNave.jsp">Swimming</a></li>
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
        </div>
    </body>
</html>
