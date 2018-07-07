package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manager's home page</title>\n");
      out.write("\n");
      out.write("        <link href=\"MCss.css\" rel=\" stylesheet\" type=\"text/css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <div id = \"container\">\n");
      out.write("            <div id = \"header\">\n");
      out.write("\n");
      out.write("                <div class = \"horizontallink\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div id = \"horizontalnav\">\n");
      out.write("\n");
      out.write("                <div id = \"navmenu\">\n");
      out.write("\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href = \"\"> Home </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href = \"\"> Update</a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href = \"\"> View </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href = \"administerEmployee.jsp\"> Administration Employee </a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href = \"\"> Hire </a> </li>\n");
      out.write("                                <li><a href = \"\"> Fire </a> </li>\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href = \"\"> Ask Requirement </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href = \"www.google.com\"> Logout </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id = \"rightnav\">\n");
      out.write("\n");
      out.write("            <div id = \"body\"> </div>\n");
      out.write("            <!--div class= \"box\"> </div-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id = \"footer\">\n");
      out.write("            <div id = \"footer_p\">\n");
      out.write("                <p>Copyright 2006: Designed by <a href = \"http://www.tty.com\">tty.com</a> </p>\n");
      out.write("                <p><a href= \"#\">Privacy Policy </a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>");
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
