<%@page import="java.util.ArrayList"%>
<%@page import="controller.Employee"%>
<%@page import="controller.EmployeeController"%>
<%
    String msg = "";
    
    if (request.getParameter("ssn") != null &&
            request.getParameter("fname") != null &&
            request.getParameter("lname") != null &&
            request.getParameter("position") != null &&
            request.getParameter("sex") != null &&
            request.getParameter("age") != null &&
            request.getParameter("salary") != null &&
            request.getParameter("username") != null) {
          
        
        int ssn=Integer.parseInt(request.getParameter("ssn"));
        int age=Integer.parseInt(request.getParameter("age"));
        float salary=Float.parseFloat(request.getParameter("salary"));
        
        boolean inserted = EmployeeController.hireEmployee(ssn,
                request.getParameter("fname"), request.getParameter("lname"),
                request.getParameter("position"), request.getParameter("sex"),
                age, salary, request.getParameter("username"));
        if(inserted) {
            msg = "<span style='color: green'>Successfully hired!!</span>";
        }
        else {
            msg = "<span style='color: red'>Failed on hiring!!</span>";
        }
    }
    
    
    if (request.getParameter("fire") != null) {
        int ssn = Integer.parseInt(request.getParameter("fire"));
        boolean deleted = EmployeeController.fireEmployee(ssn);
        if(deleted) {
            msg = "<span style='color: green'>Successfully fired!!</span>";
        }
        else {
            msg = "<span style='color: red'>Failed on firing!!</span>";
        }
    }
    
    ArrayList<Employee> employees = EmployeeController.getEmployees();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administer Employee</title>
    </head>
    <body>
        <%=msg%>
        <table border="1">
            <tr>
                <td>SSN</td>
                <td>First Name</td>
                <td>Last Name</td>
                <td>Position</td>
                <td>Sex</td>
                <td>Age</td>
                <td>Salary</td>
                <td>Username</td>
                <td></td>
            </tr>
            <%
                for (int i = 0; i < employees.size(); i++) {
                        Employee e = employees.get(i);
            %>
            <tr>
                <td><%=e.getSsn()%></td>
                <td><%=e.getFname()%></td>
                <td><%=e.getLname()%></td>
                <td><%=e.getPosition()%></td>
                <td><%=e.getSex()%></td>
                <td><%=e.getAge()%></td>
                <td><%=e.getSalary()%></td>
                <td><%=e.getUsername()%></td>
                <td><a href="administerEmployee.jsp?fire=<%=e.getSsn()%>">Fire</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <form action="administerEmployee.jsp" method="post">
            <table style="margin: 50px auto; border: 1px solid black; padding: 5px">
                <tr>
                    <td colspan="2" style="text-align: center">
                        <h2>Add Employee</h2>
                    </td>
                </tr>
                <tr>
                    <td>
                        SSN:
                    </td>
                    <td>
                        <input type="number" name="ssn" />
                    </td>
                </tr>
                <tr>
                    <td>
                         fist name:
                    </td>
                    <td>
                        <input type="text" name="fname" />
                    </td>
                </tr>
                <tr>
                    <td>
                        last name:
                    </td>
                    <td>
                        <input type="text" name="lname" />
                    </td>
                </tr>
                <tr>
                    <td>
                        position:
                    </td>
                    <td>
                        <input type="text" name="position" />
                    </td>
                </tr>
                
                <tr>
                    <td>
                        sex:
                    </td>
                    <td>
                        <select name="sex">
                            <option value="M">male</option>
                            <option value="F">femal</option>
                        </select>
      
                    </td>
                </tr>  
            <tr>
                    <td>
                        Age:
                    </td>
                    <td>
                        <input type="number" name="age" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Salary:
                    </td>
                    <td>
                        <input type="number" name="salary" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Username:
                    </td>
                    <td>
                        <input type="text" name="username" />
                    </td>
                </tr>
               <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Add"/>
                    </td>
                </tr> 
            </table>
        </form>
    </body>
</html>
