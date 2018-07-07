

<%@page import="controller.Room"%>
<%@page import="model.EmployeeModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>View Customers information</h1></center>
    <table border="1">
            <tr>
                <td>SSN</td>
                 <td>First Name</td>
                 <td>Last Name</td>
                 <td>Branch Name</td>
                 <td>Room Number</td>
                 <td>Start_Date</td>
                 <td>End_Date</td>
            </tr>
        <%
            ArrayList<Customer> customerList = null; //EmployeeModel.selectRoomreservedCustomer() ;
            ArrayList<Room> customerLis = null ; //EmployeeModel.selectRoomreservedCustomer() ;
            
            for (Customer c : customerList) {
                
                
                //out.print(s.getType()+s.getPrice()+"</br>");
                
                
            
        %>
        <tr>
            <td><%=c.getSsn()%></td>
            <td><%=c.getFname()%></td>
            <td><%=c.getLname()%></td>
            <td><--%=c.getbName()--%></td>
            <td><%--=s.getPrice()--%></td>
        </tr>
        <%
            }
           %>
        </table>
    </body>
</html>
