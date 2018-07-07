<%@page import="controller.CustomerController"%>
<%

    if (request.getParameter("ssn") != null && !"".equals(request.getParameter("ssn"))) {
        int ssn = Integer.parseInt(request.getParameter("ssn"));
        float i = CustomerController.getItemPrice(ssn);
        float h = CustomerController.getHallPrice(ssn);
        float r = CustomerController.getRoomPrice(ssn);
%>
<table border="1" cellspacing="5" cellpadding="5">
    <thead>
        <tr>
            <th>Type</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Item Price</td>
            <td><%=i%></td>
        </tr>
        <tr>
            <td>Room Price</td>
            <td><%=r%></td>
        </tr>
        <tr>
            <td>Hall Price</td>
            <td><%=h%></td>
        </tr>
        <tr>
            <td></td>
            <td><hr>
                <%=(i + r + h)%>
            </td>
        </tr>
    </tbody>
</table>
<%

    } //else {
%>
<br>
<form action="viewBill.jsp" method="POST">
    SSN <input type="number" name="ssn" value="" /><br>
    <input type="submit" value="print" />
</form>



