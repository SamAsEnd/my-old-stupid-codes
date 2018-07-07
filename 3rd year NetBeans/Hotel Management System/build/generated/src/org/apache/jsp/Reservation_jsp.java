package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.CustomerController;
import java.sql.Date;

public final class Reservation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String msg = "";

    if (request.getParameter("ssn") != null
            && request.getParameter("roomNum") != null
            && request.getParameter("hallNum") != null && request.getParameter("BNo") != null) {

        int day1 = Integer.parseInt(request.getParameter("day1"));
        int month1 = Integer.parseInt(request.getParameter("month1"));
        int year1 = Integer.parseInt(request.getParameter("year1"));

        Date d1 = new Date(year1 - 1900, month1, day1);
        int day2 = Integer.parseInt(request.getParameter("day2"));
        int month2 = Integer.parseInt(request.getParameter("month2"));
        int year2 = Integer.parseInt(request.getParameter("year2"));

        Date d2 = new Date(year2 - 1900, month2, day2);
        int ssn = Integer.parseInt(request.getParameter("ssn"));
        int roomNum = Integer.parseInt(request.getParameter("roomNum"));
        int hallNum = Integer.parseInt(request.getParameter("hallNum"));
        int BNo = Integer.parseInt(request.getParameter("BNo"));
        boolean inserted = CustomerController.reserveCustomer(ssn, BNo,
                roomNum, hallNum, d1, d2);

        if (inserted) {
            msg = "<span style='color: green'>Successfully Reserved!!</span>";
        } else {
            msg = "<span style='color: red'>Failed on Reserved!!</span>";
        }
    }


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>customer reservation page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>   <h1>Welcome To Our Hotel</h1></center>\n");
      out.write("    <form action=\"Reservation.jsp\" method=\"post\">\n");
      out.write("        <table style=\"margin: 50px auto; border: 1px solid black; padding: 5px\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" style=\"text-align: center\">\n");
      out.write("                    <h2>Customers Reservation Form</h2>\n");
      out.write("                    ");
      out.print(msg);
      out.write("\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    SSN:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\" name=\"ssn\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Branch Number:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\" name=\"BNo\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Room Number:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <select  name=\"roomNum\" >\n");
      out.write("                        <option value=\"0\">None</option>\n");
      out.write("                        ");
//
                            for (int i = 1; i <= 100; i++) {
                                out.print("<option value='" + i + "'>" + i + "</option>");
                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Start_Date:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <select  name=\"year1\" >\n");
      out.write("                        ");

                            int length = new java.util.Date().getYear() + 1900;
                            for (int y1 = 2006; y1 <= length; y1++) {
                                out.print("<option value='" + y1 + "'>" + y1 + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <select name=\"month1\">\n");
      out.write("                        ");

                            for (int m = 1; m <= 12; m++) {
                                out.print("<option value='" + m + "'>" + m + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    <select name=\"day1\">\n");
      out.write("                        ");

                            for (int d = 1; d <= 31; d++) {
                                out.print("<option value='" + d + "'>" + d + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    End_Date:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <select  name=\"year2\" >\n");
      out.write("                        ");

                            int len = new java.util.Date().getYear() + 1900;
                            for (int y2 = 2006; y2 <= len; y2++) {
                                out.print("<option value='" + y2 + "'>" + y2 + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <select name=\"month2\">\n");
      out.write("                        ");

                            for (int m = 1; m <= 12; m++) {
                                out.print("<option value='" + m + "'>" + m + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    <select name=\"day2\">\n");
      out.write("                        ");

                            for (int d = 1; d <= 31; d++) {
                                out.print("<option value='" + d + "'>" + d + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Hall Number:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <select  name=\"hallNum\" >\n");
      out.write("                        <option value=\"0\">None</option>\n");
      out.write("                        ");

                            for (int i = 1; i <= 10; i++) {
                                out.print("<option value='" + i + "'>" + i + "</option>");
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <hr></hr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" value=\"submit\"/>\n");
      out.write("                    <input type=\"Reset\" value=\"Reset\"/>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </form>\n");
      out.write("</body>\n");
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
