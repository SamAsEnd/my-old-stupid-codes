package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.Hall;
import controller.Item;
import controller.Room;
import controller.Service;
import java.util.ArrayList;
import controller.CustomerController;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>viewing services Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body >\n");
      out.write("        <h1>Types Of Services With There cost</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Type</td>\n");
      out.write("                <td>Price</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Service> serviceList = CustomerController.getServices();

                for (Service s : serviceList) {


            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(s.getType());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(s.getPrice());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <h1>Available Rooms With There appropriate cost</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Room Number</td>\n");
      out.write("                <td>Price</td>\n");
      out.write("                <td>Floor Number</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Room> roomList = CustomerController.getRooms();

                for (Room r : roomList) {


            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(r.getRoomNumber());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getPrice());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(r.getFloorNum());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <h1>Types Items With Their appropriate cost</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Item Name</td>\n");
      out.write("                <td>Price</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Item> itemList = CustomerController.getItems();

                for (Item i : itemList) {


            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(i.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(i.getPrice());
      out.write("</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        <h1>Available Halls</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Hall Name</td>\n");
      out.write("                <td>Floor Number</td>\n");
      out.write("                <td>Price</td>\n");
      out.write("                <td>Size</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");

                ArrayList<Hall> hallList = CustomerController.getHalls();

                for (Hall h : hallList) {


            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(h.getHallNum());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(h.getFloorNum());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(h.getPrice());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(h.getSize());
      out.write("</td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
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
