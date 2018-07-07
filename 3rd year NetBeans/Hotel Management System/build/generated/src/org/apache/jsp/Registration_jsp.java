package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import controller.*;

public final class Registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    String msg = "";

    if (request.getParameter("ssn") != null
            && request.getParameter("fname") != null
            && request.getParameter("lname") != null
            && request.getParameter("sex") != null
            && request.getParameter("nationality") != null
            && request.getParameter("accountNum") != null && request.getParameter("homeTown") != null
            && request.getParameter("phoneNumber") != null && request.getParameter("email") != null) {

        int ssn = Integer.parseInt(request.getParameter("ssn"));
        int accountNum = Integer.parseInt(request.getParameter("accountNum"));
        int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        boolean register = CustomerController.registerCustomer(ssn,
                request.getParameter("fname"), request.getParameter("lname"),
                request.getParameter("nationality"), request.getParameter("sex"), accountNum);
        register = CustomerController.CustomerAddress(ssn, request.getParameter("homeTown"), phoneNumber, request.getParameter("email"));
        if (register) {
            msg = "<span style='color: green'>Successfully Registered!!</span>";
        } else {
            msg = "<span style='color: red'>No Registration takes place!!</span>";
        }
    }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Reservation Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"Registration.jsp\" method=\"post\">\n");
      out.write("            <table style=\"margin: 50px auto; border: 1px solid black; padding: 5px\">\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"2\" style=\"text-align: center\">\n");
      out.write("                        <h2>Customer Registration Form</h2>\n");
      out.write("                        <span style=\"color: red\">");
      out.print(msg);
      out.write("</span>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        SSN:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"ssn\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        First Name:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"fname\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Last Name:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"lname\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Nationality:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"nationality\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        sex:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"sex\">\n");
      out.write("                            <option value=\"M\">male</option>\n");
      out.write("                            <option value=\"F\">female</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Account Number:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"accountNum\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Address:\n");
      out.write("                    </td>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        Home Town:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"homeTown\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Phone Number:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"phoneNumber\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        Email:\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"email\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"submit\"/>\n");
      out.write("                        <input type=\"Reset\" value=\"Reset\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
