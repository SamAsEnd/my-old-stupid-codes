<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Congradulations!<br/> The Student is successfully registered.</h1>
        <p>Here below is the detail of the registered student!!</p>
        <jsp:useBean id="studBeanId" type="sms.StudentBean" scope="session"/>
        <table border="1">
            <thead>
                <tr>
                    <th>Attributes</th>
                    <th> Values</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Id:</td>
                    <td><jsp:getProperty name = "studBeanId" property="id"/></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><jsp:getProperty name="studBeanId" property="firstName"/></td>
                </tr>
                <tr>
                    <td>Second Name:</td>
                    <td><jsp:getProperty name="studBeanId" property="secondName"/></td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td><jsp:getProperty name="studBeanId" property="department"/></td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><jsp:getProperty name = "studBeanId" property="age"/></td>
                </tr>
                <tr>
                    <td>GPA:</td>
                    <td><jsp:getProperty name="studBeanId" property="gpa"/></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
