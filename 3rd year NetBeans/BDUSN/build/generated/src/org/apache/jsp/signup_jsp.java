package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import com.bdusn.C.User;
import com.bdusn.C.LoginController;
import com.bdusn.C.EmailValidater;
import com.bdusn.C.SignUpController;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>BDUSN | Signup</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/all.css\"/>\r\n");
      out.write("        <link href=\"css/login.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <style>\r\n");
      out.write("            * {\r\n");
      out.write("                font-family: fantasy;\r\n");
      out.write("            }\r\n");
      out.write("            img {\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("            body {\r\n");
      out.write("                background: url('img/bgGray.jpg') repeat;\r\n");
      out.write("                height: 100%;\r\n");
      out.write("                margin: 0px;\r\n");
      out.write("            }\r\n");
      out.write("            #signUpForm {\r\n");
      out.write("                background: url(img/bg.png) repeat;\r\n");
      out.write("                display: block;\r\n");
      out.write("                width: 550px;\r\n");
      out.write("                margin: 50px auto;\r\n");
      out.write("                padding: 10px;\r\n");
      out.write("                box-shadow: 0px 0px 5px #000;\r\n");
      out.write("                border-radius: 8px;\r\n");
      out.write("            }\r\n");
      out.write("            table {\r\n");
      out.write("                width: 550px;\r\n");
      out.write("            }\r\n");
      out.write("            td {\r\n");
      out.write("                padding: 8px;\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("            td > * {\r\n");
      out.write("                color: #333;\r\n");
      out.write("                font-size: 18px;\r\n");
      out.write("            }\r\n");
      out.write("            .left {\r\n");
      out.write("                text-align: left;\r\n");
      out.write("            }\r\n");
      out.write("            .right {\r\n");
      out.write("                text-align: right;\r\n");
      out.write("            }\r\n");
      out.write("            .err {\r\n");
      out.write("                color: firebrick;\r\n");
      out.write("                font-size: 13px;\r\n");
      out.write("            }\r\n");
      out.write("            input:hover {\r\n");
      out.write("                box-shadow: 0px 0px 2px highlight;\r\n");
      out.write("            }\r\n");
      out.write("            input:focus {\r\n");
      out.write("                box-shadow: 1px 1px 3px highlight;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("            function removeErr(id) {\r\n");
      out.write("                var err = document.getElementById(id);\r\n");
      out.write("                err.innerHTML = \"&nbsp;\";\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function checkEmail()\r\n");
      out.write("            {\r\n");
      out.write("                var email = document.getElementById('_email').value;\r\n");
      out.write("                var err = document.getElementById('emailStringErr');\r\n");
      out.write("\r\n");
      out.write("                err.innerHTML = '<img src=\"img/wait.gif\" height=\"23px\" /> &nbsp;&nbsp; <span style=\"color: black\">Please wait . . .</span>';\r\n");
      out.write("\r\n");
      out.write("                var xmlhttp;\r\n");
      out.write("                if (window.XMLHttpRequest) {\r\n");
      out.write("                    // code for IE7+, Firefox, Chrome, Opera, Safari\r\n");
      out.write("                    xmlhttp = new XMLHttpRequest();\r\n");
      out.write("                }\r\n");
      out.write("                else {\r\n");
      out.write("                    // code for IE6, IE5\r\n");
      out.write("                    xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("                }\r\n");
      out.write("                xmlhttp.onreadystatechange = function()\r\n");
      out.write("                {\r\n");
      out.write("                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\r\n");
      out.write("                    {\r\n");
      out.write("                        if (xmlhttp.responseText == \"OK\") {\r\n");
      out.write("                            err.innerHTML = '<img src=\"img/good.png\" height=\"23px\" />';\r\n");
      out.write("                        }\r\n");
      out.write("                        else {\r\n");
      out.write("                            err.innerHTML = xmlhttp.responseText;\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                xmlhttp.open(\"GET\", \"ajax_email_check.jsp?email=\" + email, true);\r\n");
      out.write("                xmlhttp.send();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"signUpForm\">\r\n");
      out.write("            <form method=\"post\" action=\"signup.jsp\">\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td colspan=\"3\">\r\n");
      out.write("                            <img style=\"text-align: center\" src=\"img/logoBig.png\" width=\"380\"/><br/>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>First Name</span></td>\r\n");
      out.write("                        <td class=\"left\"><input onkeypress=\"removeErr('firstNameErr')\" type=\"text\" name=\"firstName\" required value=\"");
      out.print((firstNameString != null ? firstNameString : ""));
      out.write("\"/></td>\r\n");
      out.write("                        <td class=\"left\" style=\"width: 160px\">\r\n");
      out.write("                            <span class=\"err firstName\" id=\"firstNameErr\">\r\n");
      out.write("                                ");
      out.print(firstNameErr);
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>Last Name</span></td>\r\n");
      out.write("                        <td class=\"left\"><input onkeypress=\"removeErr('lastNameErr')\" type=\"text\" name=\"lastName\" required value=\"");
      out.print((lastNameString != null ? lastNameString : ""));
      out.write("\" /></td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <span class=\"err lastName\" id=\"lastNameErr\">\r\n");
      out.write("                                ");
      out.print(lastNameErr);
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>Date Of Birth</span></td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <select onchange=\"removeErr('dayMonthYearErr')\" name=\"day\" required>\r\n");
      out.write("                                ");

                                    for (int d = 1; d <= 31; d++) {
                                        out.println("<option value='" + d + "' "
                                                + (d == day ? "selected" : " ")
                                                + " >" + d + "</option>");
                                    }
                                
      out.write("\r\n");
      out.write("                            </select>/\r\n");
      out.write("                            <select onchange=\"removeErr('dayMonthYearErr')\" name=\"month\" required>\r\n");
      out.write("                                ");

                                    for (int m = 1; m <= 12; m++) {
                                        out.println("<option  value='" + m + "' "
                                                + (m == month ? "selected" : " ")
                                                + " >" + m + "</option>");
                                    }
                                
      out.write("\r\n");
      out.write("                            </select>/\r\n");
      out.write("                            <select  onchange=\"removeErr('dayMonthYearErr')\" name=\"year\" required>\r\n");
      out.write("                                ");

                                    for (int y = 1900; y <= LocalDate.now().getYear(); y++) {
                                        out.println("<option value='" + y + "' "
                                                + (y == year ? "selected" : " ")
                                                + " >" + y + "</option>");
                                    }
                                
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <span class=\"err dob\" id=\"dayMonthYearErr\">\r\n");
      out.write("                                ");
      out.print(dayMonthYearErr);
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>Sex</span></td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <span>\r\n");
      out.write("                                <input type=\"radio\" onchange=\"removeErr('sexStringErr')\" name=\"sex\" required value=\"M\" ");
      out.print(("M".equals(sexString) ? "checked" : ""));
      out.write(" />Male <br />\r\n");
      out.write("                                <input type=\"radio\" onchange=\"removeErr('sexStringErr')\"  name=\"sex\" required value=\"F\" ");
      out.print(("F".equals(sexString) ? "checked" : ""));
      out.write(" />Female\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <span class=\"err sex\" id=\"sexStringErr\">\r\n");
      out.write("                                ");
      out.print(sexStringErr);
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>Email</span></td>\r\n");
      out.write("                        <td class=\"left\"><input onkeypress=\"removeErr('emailStringErr')\" onblur=\"checkEmail()\" id=\"_email\"  type=\"email\" required name=\"email\" value=\"");
      out.print((emailString != null ? emailString : ""));
      out.write("\"/></td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <span class=\"err email\" id=\"emailStringErr\">\r\n");
      out.write("                                ");
      out.print(emailStringErr);
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>Password</span></td>\r\n");
      out.write("                        <td class=\"left\"><input onkeypress=\"removeErr('passStringErr')\" type=\"password\" required name=\"pass1\" /></td>\r\n");
      out.write("                        <td class=\"left\">\r\n");
      out.write("                            <span class=\"err\" id=\"passStringErr\">\r\n");
      out.write("                                ");
      out.print(passStringErr);
      out.write("\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td class=\"right\"><span>Re-Password</span></td>\r\n");
      out.write("                        <td class=\"left\"><input onkeypress=\"removeErr('passStringErr')\"  type=\"password\" required name=\"pass2\" /></td>\r\n");
      out.write("                        <td class=\"left\"><span class=\"err\"></span></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td class=\"left\"><input class=\"btn left\" type=\"submit\" name=\"form\" value=\"Signup\" /></td>\r\n");
      out.write("                        <td class=\"left\"><span class=\"err\"></span></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td></td>\r\n");
      out.write("                        <td class=\"left\"><a class=\"btn\" href=\"login.jsp\">already have an account?</a></td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
