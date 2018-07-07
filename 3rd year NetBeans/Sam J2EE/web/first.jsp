<%--
    Document   : first
    Created on : Apr 19, 2014, 8:23:57 AM
    Author     : Sam As End
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.println("Your IP address is " + request.getRemoteAddr());
        %>
        <br />

        <jsp:scriptlet>
            out.println("Your IP address is " + request.getRemoteAddr());
        </jsp:scriptlet>
        <br />

        Your IP address is <%=request.getRemoteAddr()%>
        <br />

        Your IP address is
        <jsp:expression>request.getRemoteAddr()</jsp:expression>
    </body>
</html>
