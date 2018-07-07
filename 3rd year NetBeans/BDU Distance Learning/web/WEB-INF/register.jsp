<%@page import="com.bdudl.C.Student"%>
<%@page import="com.bdudl.C.StudentController"%>
<%

    String fName = request.getParameter("fn");
    String lName = request.getParameter("sn");
    String sex = request.getParameter("sex");
    String address = request.getParameter("a");
    int asI;
    try {
        asI = Integer.parseInt(request.getParameter("ac"));
    } catch (Exception e) {
        asI = -1;
    }

    String result = null;
    String color = "";
    if (fName != null
            && lName != null
            && sex != null
            && address != null
            && asI != -1) {

        result = StudentController.register(new Student(fName, lName, sex, address, asI));

        if ("Successfully Inserted".equals(result)) {
            color = "good";
        } else {
            color = "bad";
        }
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Student</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <form action="register" method="POST">
            <table>
                <%=result != null ? "<tr><td class='center " + color + "' colspan='2'>" + result + "</td></tr>" : ""%>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="fn" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="sn" /></td>
                </tr>
                <tr>
                    <td>Sex</td>
                    <td><select name="sex">
                            <option>Male</option>
                            <option>Female</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>
                        <textarea name="a" rows="6" cols="20"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>Acad. Status</td>
                    <td><input type="number" name="ac" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td class="center"><input type="submit" value="Register" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="view">View All</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
