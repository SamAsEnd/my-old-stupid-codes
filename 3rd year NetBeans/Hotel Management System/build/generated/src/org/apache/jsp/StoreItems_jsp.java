package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.EmployeeController;

public final class StoreItems_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String msg = "";

    if (request.getParameter("OrgID") != null
            && request.getParameter("OrgName") != null
            && request.getParameter("ItemId") != null
            && request.getParameter("Quantity") != null
            && request.getParameter("Price") != null) {

        int OrgID = Integer.parseInt(request.getParameter("OrgID"));
        int ItemId = Integer.parseInt(request.getParameter("ItemId"));
        int Quantity = Integer.parseInt(request.getParameter("Quantity"));
        float Price = Float.parseFloat(request.getParameter("Price"));
        boolean store = EmployeeController.storeItem(OrgID,
                request.getParameter("OrgName"), ItemId,
                Quantity, Price);
        if (store) {
            msg = "<span style='color: green'>Successfully Stored!!</span>";
        } else {
            msg = "<span style='color: red'>Not stored!!</span>";
        }
    }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Store keeper Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center><h1>Store Item</h1></center>\n");
      out.write("    <form action=\"\" method=\"post\">\n");
      out.write("        <table style=\"margin: 50px auto; border: 1px solid black; padding: 5px\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" style=\"text-align: center\">\n");
      out.write("                    <span style=\"color: red\">");
      out.print(msg);
      out.write("</span>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Organization ID:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\" name=\"OrgID\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Organization Name:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"OrgName\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Item ID:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\" name=\"ItemId\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Quantity:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"number\" name=\"Quantity\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    Price:\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"Price\" />\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td></td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"submit\" value=\"save\"/>\n");
      out.write("                    <input type=\"Reset\" value=\"Reset\"/>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            </body>\n");
      out.write("            </html>\n");
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
