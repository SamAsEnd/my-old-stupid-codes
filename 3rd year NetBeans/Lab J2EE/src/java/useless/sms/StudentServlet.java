package useless.sms;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    private String firstName, secondName, id, department;
    private int age;
    private char sex;
    private double gpa;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //reading from the request
        id = request.getParameter("id");
        firstName = request.getParameter("firstName");
        secondName = request.getParameter("secondName");
        age = Integer.parseInt(request.getParameter("age"));
        department = request.getParameter("deparment");
        sex = (request.getParameter("sex")).charAt(0);
        gpa = Double.parseDouble(request.getParameter("gpa"));

        String address = null;

        if (id != null) {
            address = "/StudentInterface.jsp";
        } else {
            address = "/SuccessfulRegistration.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

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
    }
}
