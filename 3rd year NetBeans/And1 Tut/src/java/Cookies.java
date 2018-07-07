

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookies extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] c = req.getCookies();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.print("Cookies are: <br>");

        if (c == null) {
            out.print("No cookie");
        } else {
            for (int i = 0; i < c.length; i++) {
                out.println(c[i].getName() + " : " + c[i].getValue() + "<br />");
            }
        }

        int count = 0;
        if (c == null) {
            out.print("No cookie");
        } else {
            for (int i = 0; i < c.length; i++) {
                if ("COUNT".equals(c[i].getName())) {
                    count = Integer.parseInt(c[i].getValue());
                }
            }
        }

        count++;

        out.println("<h1>You visited this page " + count + " times!!</h1>");

        Cookie cookie = new Cookie("COUNT", "" + count);
        // delete
        // cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

}
