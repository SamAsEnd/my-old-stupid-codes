<%@page import="com.bdusn.C.EmailValidater"%><%
    if (request.getParameter("email") != null) {
        String rslt = EmailValidater.ajaxValidateEmailAddress(request.getParameter("email"));
        out.print(rslt);
    }
%>