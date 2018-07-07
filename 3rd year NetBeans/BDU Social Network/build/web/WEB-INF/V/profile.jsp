<%@page import="com.bdusn.M.UserModel"%>
<%@page import="com.bdusn.C.oo.User_Class"%>
<%
    if (session.isNew() || session.getAttribute("userID") == null) {
        response.sendRedirect("login");
    }

    boolean ownProfile = ((Integer) session.getAttribute("userID")).intValue() == Integer.parseInt(request.getParameter("user"));

    User_Class user = UserModel.load((Integer) session.getAttribute("userID"));
    user.load();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Home</title>
        <link href="css/normalize.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/menu/style.css" type="text/css" />
        <link rel="stylesheet" href="css/all.css" type="text/css" />
        <style>


        </style>
        <script src="js/jquery-2.0.0.min.js"></script>
        <script>


        </script>

    </head>

    <body>

        <header>
            <div id="headerContent">
                <div id="logo">
                    <a href="/"><img src="img/logo.png" alt="Logo"/></a>
                </div>

                <div id="search">
                    <img src="img/Find.png" height="32" align="center"/>
                    <input type="search" name="searchQuery" placeholder="Type the search query"/>
                </div>

                <div id="control">
                    <ul id="menuCSS" class="topmenu">
                        <li class="topfirst"><a href="home" title="Go to Home Page" style="height:15px;line-height:15px;">Home</a></li>
                        <li class="topmenu"><a <%=(ownProfile ? "class='pressed'" : "")%> href="profile?user=<%=user.getUserID()%>" title="Go to your profile" style="height:15px;line-height:15px;">
                                <%=user.getFirstName() + " " + user.getLastName()%>
                            </a>
                        </li>
                        <li class="toplast"><a href="logout" title="Logout from BDUSN" style="height:15px;line-height:15px;">Logout</a></li>
                    </ul>
                </div>
            </div>
        </header>

        <section>
            <table border="0px" cellspacing="5px">
                <tr>
                    <td>
                        <nav id="menus">
                            <ul>
                                <li class="navMenu">
                                    <div >

                                    </div>
                                </li>
                                <li class="navMenu">
                                    <div >

                                    </div>
                                </li>
                                <li class="navMenu">
                                    <div >

                                    </div>
                                </li>
                            </ul>
                        </nav>
                    </td>
                    <td>
                        <div id="content">
                            <div class="post">

                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </section>
        <footer>
            <div id="footerContent">

            </div>
            <div id="chat">

            </div>
        </footer>
    </body>
</html>
