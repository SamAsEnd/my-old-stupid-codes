package com.samasend;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestMe extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ArithmeticException {

        int x = 4 / 0;

        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Server", "Why do u wanna known?");
        Cookie cookie = new Cookie("test", "me");
        cookie.setSecure(true);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        response.addCookie(cookie);
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestMe</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestMe at " + request.getContextPath() + "</h1>");
            out.println("<table border='1px' cellpadding='2px'>");
            TreeMap<String, String[]> map = new TreeMap<>(request.getParameterMap());
            for (String key : map.keySet()) {
                String[] parameterValues = request.getParameterValues(key);
                out.println("<tr>"
                        + "<td>" + key + "</td>"
                );
                out.println("<td>");
                for (String val : parameterValues) {
                    out.println(val + "<br>");
                }
                out.println("</td></tr>");
            }
            out.println("</table>");

            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String data = request.getHeader(headerName);
                out.println(headerName + "&nbsp;&nbsp;&nbsp;&nbsp;" + data + "<br/>");
            }

            out.println("<form method=\"POST\" action=\"TestMe.do\">\n"
                    + "    <input type=\"file\" name=\"f\" />\n"
                    + "    <input type=\"submit\" value=\"SEND\" />\n"
                    + "</form>\n"
                    + "");

            ServletInputStream sis = request.getInputStream();
            File tmp = File.createTempFile("________", "_______.raw");
            PrintStream fileStream = new PrintStream(tmp);
            while (!sis.isFinished()) {
                fileStream.write(sis.read());
            }
            sis.close();
            fileStream.close();
            out.println(tmp.getAbsolutePath());
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
