
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

    private String firstName, secondName;
    private int age;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //reading from the request
        firstName = request.getParameter("firstName");
        secondName = request.getParameter("secondName");
        age = Integer.parseInt(request.getParameter("age"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>"
                + "<HEAD><TITLE> Hello All! </Title>"
                + "<link rel=\"stylesheet\" href=\"style.css\" />"
                + "</HEAD><Body>"
                + "<table>"
                + "<tr><td  class='good'>Welcome to Advanced Programming Project</td></tr>"
                + "<tr><td colspan='2'>The details of the student is</td></tr>"
                + "<tr><td>FirstName</td><td>" + firstName + "</td></tr>"
                + "<tr><td>Second Name</td><td>" + secondName + "</td></tr>"
                + "<tr><td>Age</td><td>" + age + "</td></tr>"
                + "</table>"
                + "</BODY></HTML>");
        out.close();
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
