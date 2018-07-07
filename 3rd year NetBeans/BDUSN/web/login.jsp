<%@page import="com.bdusn.C.User"%>
<%@page import="com.bdusn.C.LoginController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user") != null) {
        // means the user is already loged in
        // so send to the home page
        response.sendRedirect("home.jsp");
    }

    String errorString = "&nbsp;"; // &nbsp; is HTML Entity for space

    /*
     get the content of the form
     from the request implicit object
     */
    String emailString = request.getParameter("email");     // name="email"
    String passString = request.getParameter("pass");       // name="pass"

    // check if BOTH email and password are submitted
    if (emailString != null && passString != null) {

        // create a login controler object with email and password
        LoginController controller = new LoginController(emailString, passString);

        // get the user with that email and password
        User user = controller.getUser();

        if (user != null) {
            // means the user exist
            session.setAttribute("user", user);
            response.sendRedirect("home.jsp");
        } else {
            // means the user DOES NOT EXIST
            errorString = "Incorrect email and password!!!";
        }
    }

%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BDUSN | Login</title>
        <link rel="stylesheet" href="css/all.css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <style>
            * {
                font-family: fantasy;
            }
            body {
                background: url('img/bgGray.jpg') repeat;
                height: 100%;
            }
            #loginForm {
                background: url(img/bg.png) repeat;
                display: block;
                width: 400px;
                margin: 100px auto;
                padding: 10px;
                box-shadow: 3px 3px 20px #000;
                border-radius: 15px;
            }
            td {
                padding: 8px;
                text-align: center;
            }
            td > * {
                color: #333;
                font-size: 18px;
            }
            .left {
                text-align: left;
            }
            .right {
                text-align: right;
            }
            input:hover {
                box-shadow: 0px 0px 2px highlight;
            }
            input:focus {
                box-shadow: 1px 1px 3px highlight;
            }
        </style>
        <script>

            function removeErrAndInfo() {
                var err = document.getElementById('err');
                var msg = document.getElementById('msg');

                err.innerHTML = "&nbsp;";
                msg.innerHTML = "&nbsp;";
            }

        </script>
    </head>
    <body>
        <div id="loginForm">
            <form method="post" action="login.jsp">
                <table>
                    <tr>
                        <td colspan="2">
                            <img src="img/logoBig.png" width="380px"/>
                            <span id="err" style="color: firebrick"><%=errorString%></span>
                            <span id="msg" style="color: #6bd600">
                                <%
                                    if (session.getAttribute("msg") != null) {
                                        out.print(session.getAttribute("msg"));
                                        session.removeAttribute("msg");
                                    }
                                %>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>Email</span></td>
                        <td class="left"><input type="email" name="email" onkeypress="removeErrAndInfo()" required value="<%=(emailString != null ? emailString : "")%>"/></td>
                    </tr>
                    <tr>
                        <td class="right"><span>Password</span></td>
                        <td class="left"><input type="password" name="pass" onkeypress="removeErrAndInfo()" required /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="left"><input class="btn left" type="submit" value="Login" /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="left">
                            <a class="btn" href="signup.jsp">Create new account?</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
