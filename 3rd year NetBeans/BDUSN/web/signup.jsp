<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.bdusn.C.User"%>
<%@page import="com.bdusn.C.LoginController"%>
<%@page import="com.bdusn.C.EmailValidater"%>
<%@page import="com.bdusn.C.SignUpController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("user") != null) {
        // means already loged in
        response.sendRedirect("home.jsp");
    }

    String firstNameString = null;
    String lastNameString = null;
    String dayString = null;
    String monthString = null;
    String yearString = null;
    String sexString = null;
    String emailString = null;
    String pass1String = null;
    String pass2String = null;

    String firstNameErr = "&nbsp;";
    String lastNameErr = "&nbsp;";
    String dayMonthYearErr = "&nbsp;";
    String sexStringErr = "&nbsp;";
    String emailStringErr = "&nbsp;";
    String passStringErr = "&nbsp;";

    int day = 0;
    int month = 0;
    int year = 0;

    if (request.getParameter("form") != null) {
        boolean valid = true;

        // validate firstName
        firstNameString = request.getParameter("firstName");
        firstNameErr = "&nbsp;";
        if (firstNameString == null || firstNameString.length() < 3) {
            firstNameErr = "First Name too short!";
            valid = false;
        }

        // validate lastName
        lastNameString = request.getParameter("lastName");
        lastNameErr = "&nbsp;";
        if (lastNameString == null || lastNameString.length() < 3) {
            lastNameErr = "Last Name too short!";
            valid = false;
        }

        dayMonthYearErr = "&nbsp;";

        // validate day
        dayString = request.getParameter("day");
        try {
            day = Integer.parseInt(dayString);
        } catch (NumberFormatException nfe) {
            day = -1;
            dayMonthYearErr = "Select a day";
            valid = false;
        }

        // validate month
        monthString = request.getParameter("month");
        try {
            month = Integer.parseInt(monthString);
        } catch (NumberFormatException nfe) {
            month = -1;
            dayMonthYearErr = "Select a Month";
            valid = false;
        }

        // validate year
        yearString = request.getParameter("year");
        try {
            year = Integer.parseInt(yearString);
        } catch (NumberFormatException nfe) {
            year = -1;
            dayMonthYearErr = "Select a Year";
            valid = false;
        }

        // validate day month & year
        LocalDate date = null;
        try {
            date = LocalDate.of(year, month, day);
        } catch (Exception e) {
            dayMonthYearErr = "Invalid day month combination";
            valid = false;
        }

        // validate sex
        sexString = request.getParameter("sex");
        sexStringErr = "&nbsp;";
        if (!"M".equals(sexString) && !"F".equals(sexString)) {
            sexStringErr = "Select Sex";
            valid = false;
        }

        // validate email
        emailString = request.getParameter("email");
        emailStringErr = "&nbsp;";
        if (emailString == null || !EmailValidater.validateEmailAddress(emailString)) {
            emailStringErr = "Invalid Email";
            valid = false;
        }

        // validate password
        pass1String = request.getParameter("pass1");
        pass2String = request.getParameter("pass2");
        passStringErr = "&nbsp;";

        if (pass1String == null || !pass1String.equals(pass2String)) {
            passStringErr = "Password doesn't match";
            valid = false;
        }

        if (valid) {
            User user = new User(emailString, pass1String, firstNameString, lastNameString, sexString.charAt(0), date);
            if (SignUpController.insert(user)) {
                session.setAttribute("msg", "Account registered. Please login!!");
                response.sendRedirect("login.jsp");
            }
        }
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BDUSN | Signup</title>
        <link rel="stylesheet" href="css/all.css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <style>
            * {
                font-family: fantasy;
            }
            img {
                text-align: center;
            }
            body {
                background: url('img/bgGray.jpg') repeat;
                height: 100%;
                margin: 0px;
            }
            #signUpForm {
                background: url(img/bg.png) repeat;
                display: block;
                width: 550px;
                margin: 50px auto;
                padding: 10px;
                box-shadow: 0px 0px 5px #000;
                border-radius: 8px;
            }
            table {
                width: 550px;
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
            .err {
                color: firebrick;
                font-size: 13px;
            }
            input:hover {
                box-shadow: 0px 0px 2px highlight;
            }
            input:focus {
                box-shadow: 1px 1px 3px highlight;
            }
        </style>
        <script>

            function removeErr(id) {
                var err = document.getElementById(id);
                err.innerHTML = "&nbsp;";
            }

            function checkEmail()
            {
                var email = document.getElementById('_email').value;
                var err = document.getElementById('emailStringErr');

                err.innerHTML = '<img src="img/wait.gif" height="23px" /> &nbsp;&nbsp; <span style="color: black">Please wait . . .</span>';

                var xmlhttp;
                if (window.XMLHttpRequest) {
                    // code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp = new XMLHttpRequest();
                }
                else {
                    // code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        if (xmlhttp.responseText == "OK") {
                            err.innerHTML = '<img src="img/good.png" height="23px" />';
                        }
                        else {
                            err.innerHTML = xmlhttp.responseText;
                        }
                    }
                }
                xmlhttp.open("GET", "ajax_email_check.jsp?email=" + email, true);
                xmlhttp.send();
            }
        </script>
    </head>
    <body>
        <div id="signUpForm">
            <form method="post" action="signup.jsp">
                <table>
                    <tr>
                        <td colspan="3">
                            <img style="text-align: center" src="img/logoBig.png" width="380"/><br/>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>First Name</span></td>
                        <td class="left"><input onkeypress="removeErr('firstNameErr')" type="text" name="firstName" required value="<%=(firstNameString != null ? firstNameString : "")%>"/></td>
                        <td class="left" style="width: 160px">
                            <span class="err firstName" id="firstNameErr">
                                <%=firstNameErr%>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>Last Name</span></td>
                        <td class="left"><input onkeypress="removeErr('lastNameErr')" type="text" name="lastName" required value="<%=(lastNameString != null ? lastNameString : "")%>" /></td>
                        <td class="left">
                            <span class="err lastName" id="lastNameErr">
                                <%=lastNameErr%>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>Date Of Birth</span></td>
                        <td class="left">
                            <select onchange="removeErr('dayMonthYearErr')" name="day" required>
                                <%
                                    for (int d = 1; d <= 31; d++) {
                                        out.println("<option value='" + d + "' "
                                                + (d == day ? "selected" : " ")
                                                + " >" + d + "</option>");
                                    }
                                %>
                            </select>/
                            <select onchange="removeErr('dayMonthYearErr')" name="month" required>
                                <%
                                    for (int m = 1; m <= 12; m++) {
                                        out.println("<option  value='" + m + "' "
                                                + (m == month ? "selected" : " ")
                                                + " >" + m + "</option>");
                                    }
                                %>
                            </select>/
                            <select  onchange="removeErr('dayMonthYearErr')" name="year" required>
                                <%
                                    for (int y = 1900; y <= LocalDate.now().getYear(); y++) {
                                        out.println("<option value='" + y + "' "
                                                + (y == year ? "selected" : " ")
                                                + " >" + y + "</option>");
                                    }
                                %>
                            </select>
                        </td>
                        <td class="left">
                            <span class="err dob" id="dayMonthYearErr">
                                <%=dayMonthYearErr%>
                            </span>
                        </td>
                    </tr>

                    <tr>
                        <td class="right"><span>Sex</span></td>
                        <td class="left">
                            <span>
                                <input type="radio" onchange="removeErr('sexStringErr')" name="sex" required value="M" <%=("M".equals(sexString) ? "checked" : "")%> />Male <br />
                                <input type="radio" onchange="removeErr('sexStringErr')"  name="sex" required value="F" <%=("F".equals(sexString) ? "checked" : "")%> />Female
                            </span>
                        </td>
                        <td class="left">
                            <span class="err sex" id="sexStringErr">
                                <%=sexStringErr%>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>Email</span></td>
                        <td class="left"><input onkeypress="removeErr('emailStringErr')" onblur="checkEmail()" id="_email"  type="email" required name="email" value="<%=(emailString != null ? emailString : "")%>"/></td>
                        <td class="left">
                            <span class="err email" id="emailStringErr">
                                <%=emailStringErr%>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>Password</span></td>
                        <td class="left"><input onkeypress="removeErr('passStringErr')" type="password" required name="pass1" /></td>
                        <td class="left">
                            <span class="err" id="passStringErr">
                                <%=passStringErr%>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td class="right"><span>Re-Password</span></td>
                        <td class="left"><input onkeypress="removeErr('passStringErr')"  type="password" required name="pass2" /></td>
                        <td class="left"><span class="err"></span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="left"><input class="btn left" type="submit" name="form" value="Signup" /></td>
                        <td class="left"><span class="err"></span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="left"><a class="btn" href="login.jsp">already have an account?</a></td>
                        <td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
