

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Form extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doReq(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doReq(request, response);
    }

    private void doReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String[] like = request.getParameterValues("like");
        if (fname == null) {
            fname = "Guest";
        }

        if (lname == null) {
            lname = "";
        }

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("Welcome " + fname + " " + lname + "<br> You Like: ");

        if (like != null) {
            for (int i = 0; i < like.length; i++) {
                out.println(like[i] + " ");
            }
        }
    }

}
