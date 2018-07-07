<%@page import="com.bdusn.C.LoginController"%>
<%
    // redirect already loged in users to hom page
    if (!session.isNew() && session.getAttribute("userID") != null) {
        response.sendRedirect("home");
    }

    String errorMsg = "&nbsp;";

    // check for login form
    if (request.getParameter("email") != null && request.getParameter("password") != null) {
        String emailString = request.getParameter("email");
        String passwordString = request.getParameter("password");

        LoginController loginController = new LoginController(emailString, passwordString);

        if (loginController.validate()) {
            session.setAttribute("userID", new Integer(loginController.getUserID()));
            response.sendRedirect("home");
        } else {
            errorMsg = "Invalid email and password";
        }
    }

%><%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css" />
    </head>
    <body>
        <div id="content">
            <table width="500" border="0">
                <tr>
                    <td colspan="2">
                        <img src="img/logoBig.png" alt="Logo" width="500"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" height="25px"></td>
                </tr>
                <tr>
                    <td id="lock" width="138px">&nbsp;</td>
                    <td>
                        <form action="login" method="post">
                            <table border="0">
                                <tr>
                                    <td></td>
                                    <td class="centerAlign">
                                        <span id="errorMsg">
                                            <%= errorMsg%>
                                        </span>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="loginTxt">Email</span>
                                    </td>
                                    <td>
                                        <input class="loginTxt" type="email" name="email"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="loginTxt">Password</span>
                                    </td>
                                    <td>
                                        <input class="loginTxt" type="password" name="password"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td height="40px" class="centerAlign">
                                        <input class="loginTxt btn" type="submit" value="Login"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
