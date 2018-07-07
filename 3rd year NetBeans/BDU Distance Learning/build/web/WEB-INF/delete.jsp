<%@page import="com.bdudl.C.StudentController"%>
<%
    String idString = request.getParameter("id");
    if (idString != null) {
        int id = Integer.parseInt(idString);
        StudentController.deleteStudent(id);
    }
    response.sendRedirect("view");
%>
