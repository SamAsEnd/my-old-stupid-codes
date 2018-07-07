<%@page import="com.bdudl.C.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bdudl.C.StudentController"%>
<%

    ArrayList<Student> students = StudentController.getAllStudents();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
        <style>
            td,th{
                text-align: left;
                vertical-align: top;
                border: 1px dashed burlywood;
                padding: 6px;
                font-size: 14px;
                transition: 0.4s all;
            }
            tr:hover {
                border: 1px solid burlywood;
                background-color: moccasin;
            }
            table {
                border: 2px solid brown;
                margin: 50px auto;
            }
            th {
                font-size: 18px;
                font-weight: bold;
            }
            input[type="submit"],a {
                padding: 3px 10px;
                color: black;
                text-decoration: none;
                border: 1px brown solid;
                border-radius: 3px;
                box-shadow: 2px 2px 5px #333;
            }
            input[type="submit"] {
                display: block;
            }
            input[type="submit"]:hover,a:hover {
                background-color: chocolate;
            }
        </style>
    </head>
    <body>
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Sex</th>
                <th>Address</th>
                <th>Acad. Status</th>
                <th>&nbsp;</th>
            </tr>
            <%
                for (Student student : students) {
                    out.println("<tr>\n"
                            + "                <td>" + student.getFirstName() + "</td>\n"
                            + "                <td>" + student.getLastName() + "</td>\n"
                            + "                <td>" + student.getSex() + "</td>\n"
                            + "                <td>" + student.getAddress() + "</td>\n"
                            + "                <td>" + student.getAcadamicStatus() + "</td>\n"
                            + "                <td><a href='delete?id=" + student.getId() + "'>Delete</a></td>\n"
                            + "            </tr>");
                }
            %>
            <tr>
                <td colspan="6" style="text-align: center">
                    <a href="register" style="width: 150px; margin: 3px 0px">Register</a>
                </td>
            </tr>
        </table>
    </body>
</html>
