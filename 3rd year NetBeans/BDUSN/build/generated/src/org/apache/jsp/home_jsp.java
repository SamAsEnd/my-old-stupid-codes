package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.bdusn.C.User;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    User user = (User) session.getAttribute("user");
    if (user == null) {
        // means NOT loged in
        response.sendRedirect("login.jsp");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>BDUSN | Home</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/css3menu1/style.css\" type=\"text/css\" />\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color: rgb(241,241,241);\n");
      out.write("                margin: 0px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header {\n");
      out.write("                width: 100%;\n");
      out.write("                height: 50px;\n");
      out.write("                position: fixed;\n");
      out.write("                background-image: linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);\n");
      out.write("                background-image: -o-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);\n");
      out.write("                background-image: -moz-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);\n");
      out.write("                background-image: -webkit-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);\n");
      out.write("                background-image: -ms-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);\n");
      out.write("\n");
      out.write("                background-image: -webkit-gradient(\n");
      out.write("                    linear,\n");
      out.write("                    left bottom,\n");
      out.write("                    left top,\n");
      out.write("                    color-stop(0.16, #3C3C3C),\n");
      out.write("                    color-stop(0.58, #5A5A5A)\n");
      out.write("                    );\n");
      out.write("\n");
      out.write("                margin: 0px;\n");
      out.write("                top: 0px; /* ear: 25px */\n");
      out.write("                box-shadow: #666 0px 5px 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header > #headerContent {\n");
      out.write("                width: 1000px;\n");
      out.write("                margin: 0px auto;\n");
      out.write("                height: inherit;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header > #headerContent > #logo {\n");
      out.write("                left: 10px;\n");
      out.write("                height: inherit;\n");
      out.write("                width: 300px;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header > #headerContent > #logo {\n");
      out.write("                left: 10px;\n");
      out.write("                height: inherit;\n");
      out.write("                width: 300px;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header > #headerContent > #search {\n");
      out.write("                height: 34px;\n");
      out.write("                width: 300px;\n");
      out.write("                margin: 8px;\n");
      out.write("                float: left;\n");
      out.write("                padding: 3px;\n");
      out.write("                background-color: #EBEBEB;\n");
      out.write("                border: #FFF solid 1px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header > #headerContent > #search input{\n");
      out.write("                background-color: #EBEBEB;\n");
      out.write("                border: none;\n");
      out.write("                margin: 0px 3px;\n");
      out.write("                padding: 0px;\n");
      out.write("                height: 30px;\n");
      out.write("                width: 180px;\n");
      out.write("                vertical-align: middle;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            body > header > #headerContent > #control {\n");
      out.write("                height: 50px;\n");
      out.write("                width: auto;\n");
      out.write("                float: right;\n");
      out.write("                padding: 6px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div id=\"headerContent\">\n");
      out.write("                <div id=\"logo\">\n");
      out.write("                    <a href=\"/\"><img src=\"img/logo.png\" alt=\"Logo\"/></a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"search\">\n");
      out.write("                    <img src=\"img/Find.png\" height=\"32\" align=\"center\"/>\n");
      out.write("                    <input type=\"search\" name=\"searchQuery\" placeholder=\"Type the search query\"/>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id=\"control\">\n");
      out.write("                    <ul id=\"css3menu1\" class=\"topmenu\">\n");
      out.write("                        <li class=\"topfirst\"><a href=\"home.jsp\" title=\"Go to Home Page\" style=\"height:18px;line-height:18px;\">Home</a></li>\n");
      out.write("                        <li class=\"topmenu\"><a href=\"#\" title=\"Go to your profile\" style=\"height:18px;line-height:18px;\">\n");
      out.write("                                ");
      out.print(user.getFirstName() + " " + user.getLastName());
      out.write("\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"toplast\"><a href=\"logout.jsp\" title=\"Logout from BDUSN\" style=\"height:18px;line-height:18px;\">Logout</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <footer>\n");
      out.write("            <div style=\"\">\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
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
