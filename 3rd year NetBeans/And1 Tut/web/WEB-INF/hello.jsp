<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%

                if (session.isNew()) {
                    out.print("NEW session");
                } else {
                    out.print("OLD session");
                }
                int count;
                try {
                    count = ((Integer) session.getAttribute("count"));
                } catch (Exception e) {
                    count = 0;
                }

                count++;

                out.println("<h1>You visited this page " + count + " times!!</h1>");

                session.setAttribute("count", new Integer(count));

            %>
        </h1>
    </body>
</html>
