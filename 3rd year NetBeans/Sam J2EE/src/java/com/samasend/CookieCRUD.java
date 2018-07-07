package com.samasend;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sam As End
 */
public class CookieCRUD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cookie[] cookies = request.getCookies();

        if (request.getParameter("name") != null
                && request.getParameter("val") != null) {

            Cookie cookie = new Cookie(request.getParameter("name"), request.getParameter("val"));
            response.addCookie(cookie);
        }

        if (request.getParameter("del") != null) {

            Cookie cookie = new Cookie(request.getParameter("del"), "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieCRUD</title><script>\n"
                    + "            function edit(name, val) {\n"
                    + "                document.getElementById('name').value = name;\n"
                    + "                document.getElementById('val').value = val;\n"
                    + "                //document.getElementById('name').focus();\n"
                    + "            }\n"
                    + "        </script>");
            out.println("</head>");
            out.println("<body> <a href='" + request.getRequestURI() + "'> REFRESH </a>");

            out.println("<form method=\"post\" action=\"" + request.getRequestURI() + "\">\n"
                    + "            Name: <input type=\"text\" name=\"name\" id=\"name\"/>\n"
                    + "            Value: <input type=\"text\" name=\"val\" id=\"val\"/>\n"
                    + "            <input type=\"submit\" value=\"Add Cookie\" />\n"
                    + "        </form>");

            out.println("<table><tr><td>Name</td><td>Value</td><td>&nbsp;</td><td>&nbsp;</td></tr>");

            for (Cookie cookie : cookies) {
                out.println("            <tr>\n"
                        + "                <td>" + cookie.getName() + "</td>\n"
                        + "                <td>" + cookie.getValue() + "</td>\n"
                        + "                <td><a href=\"javascript:edit('" + cookie.getName() + "','" + cookie.getValue() + "');\">Edit</a></td>\n"
                        + "                <td><a href=\"" + request.getRequestURI() + "?del=" + cookie.getName() + "\">Delete</a></td>\n"
                        + "            </tr>\n");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
