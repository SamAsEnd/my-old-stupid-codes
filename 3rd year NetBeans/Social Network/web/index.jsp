<%--
    Document   : index
    Created on : Apr 13, 2014, 4:23:58 AM
    Author     : Sam As End
--%>
<%@page import="java.util.TreeMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    TreeMap<String, String> map = new TreeMap<String, String>();
%>
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies) {
        map.put(cookie.getName(), cookie.getValue());
    }
%>
<!DOCTYPE html>
<html xmlns:h="http://java.sun.com/jsf/html" xmlns:f="http://java.sun.com/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>

        </table>
    </body>
</html>
