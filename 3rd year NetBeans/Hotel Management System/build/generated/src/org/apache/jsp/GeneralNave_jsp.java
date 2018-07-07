package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class GeneralNave_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/strict.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>SummerLandHotel home page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"General.css\" type=\"text/css\" media=\"screen\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"container\">\n");
      out.write("            <div id=\"position1\">\n");
      out.write("                <div id=\"header\" title=\"SummerLandHotelManagmentSystem\" >\n");
      out.write("                    <object  class=\"leftswf\" id=\"obj1\" border=\"0\" height=\"63\" width=\"50\">\n");
      out.write("                        <embed src=\"image/sum.jpg\"   height=\"120\" width=\"155\"></object>\n");
      out.write("\n");
      out.write("                    <object  class=\"rightswf\" id=\"obj1\" border=\"0\" height=\"63\" width=\"100\">\n");
      out.write("                        <embed src=\"image/sum.jpg\"   height=\"120\" width=\"100\"></object>\n");
      out.write("                    SummerLand Hotel Management</br>\n");
      out.write("                    System\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div id=\"mainnav\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"GeneralNave.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"#\"><small>Reservation</small></a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href = \"Reservation.jsp\"> Room and Hall</a> </li>\n");
      out.write("                                <li><a href = \"\"> Restaurant </a> </li>\n");
      out.write("                                <li><a href = \"\"> Change Reservation </a> </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"Registration.jsp\">Registration</a></li>\n");
      out.write("\n");
      out.write("                        <li><a href=\"#\">View</a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href = \"\"> Room </a> </li>\n");
      out.write("                                <li><a href = \"\"> Service </a> </li>\n");
      out.write("                                <li><a href = \"\"> Hall </a> </li>\n");
      out.write("                                <li><a href = \"\"> Item </a> </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"GeneralNave.jsp\">About us</a></li>\n");
      out.write("                        <li><a href=\"login.jsp\">Login</a></li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"menu\">\n");
      out.write("                <h3>\n");
      out.write("                    Services\n");
      out.write("                </h3>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"GeneralNave.jsp\">Car </a></li>\n");
      out.write("                    <li><a href=\"GeneralNave.jsp\">Swimming</a></li>\n");
      out.write("                    <li><a href=\"GeneralNave.jsp\">Parking</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <h3>\n");
      out.write("                    Information About Rooms\n");
      out.write("                </h3>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"GeneralNave.jsp\">Rooms</a></li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <h3>\n");
      out.write("                    Information About Halls\n");
      out.write("                </h3>\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"GeneralNave.jsp\">Hall</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
