package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.CustomerController;

public final class viewBill_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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


    if (request.getParameter("ssn") != null && !"".equals(request.getParameter("ssn"))) {
        int ssn = Integer.parseInt(request.getParameter("ssn"));
        float i = CustomerController.getItemPrice(ssn);
        float h = CustomerController.getHallPrice(ssn);
        float r = CustomerController.getRoomPrice(ssn);

      out.write("\n");
      out.write("<table border=\"1\" cellspacing=\"5\" cellpadding=\"5\">\n");
      out.write("    <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Type</th>\n");
      out.write("            <th>Price</th>\n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("        <tr>\n");
      out.write("            <td>Item Price</td>\n");
      out.write("            <td>");
      out.print(i);
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Room Price</td>\n");
      out.write("            <td>");
      out.print(r);
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>Hall Price</td>\n");
      out.write("            <td>");
      out.print(h);
      out.write("</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td></td>\n");
      out.write("            <td><hr>\n");
      out.write("                ");
      out.print((i + r + h));
      out.write("\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </tbody>\n");
      out.write("</table>\n");


    } //else {

      out.write("\n");
      out.write("<br>\n");
      out.write("<form action=\"viewBill.jsp\" method=\"POST\">\n");
      out.write("    SSN <input type=\"number\" name=\"ssn\" value=\"\" /><br>\n");
      out.write("    <input type=\"submit\" value=\"print\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
