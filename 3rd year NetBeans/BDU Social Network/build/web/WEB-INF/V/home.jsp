<form action="home.jsp" method="POST">
</form><%@page import="com.bdusn.C.oo.User_Class"%>
<%@page import="com.bdusn.M.UserModel"%>
<%
    if (session.isNew() || session.getAttribute("userID") == null) {
        response.sendRedirect("login");
    }
    User_Class user = UserModel.load((Integer) session.getAttribute("userID"));
    if (user != null) {
        user.load();
    } else {
        session.invalidate();
        response.sendRedirect("login");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Home</title>
        <link href="css/normalize.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/menu/style.css" type="text/css" />
        <link rel="stylesheet" href="css/menu2/style.css" type="text/css" />
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
                        <li class="topfirst"><a class="pressed" href="home" title="Go to Home Page" style="height:15px;line-height:15px;">Home</a></li>
                        <li class="topmenu"><a href="profile?user=<%=user.getUserID()%>" title="Go to your profile" style="height:15px;line-height:15px;">
                                <%=user.getFirstName() + " " + user.getLastName()%>
                            </a>
                        </li>
                        <li class="toplast"><a href="logout" title="Logout from BDUSN" style="height:15px;line-height:15px;">Logout</a></li>
                    </ul>
                </div>
            </div>
        </header>

        <section>
            <table border="0" cellspacing="10" style="width: 900px; margin: auto; text-align: center">
                <tr>
                    <td valign="top" width="120px">
                        <nav id="menus">
                            <ul id="navCSS" class="topmenu" style="margin: 50px auto">
                                <li class="topfirst"><a class="pressed" href="home" style="width:98px;">Home</a></li>
                                <li class="topmenu"><a href="message" style="width:98px;"><span>Message</span></a>
                                    <ul>
                                        <li class="subfirst"><a href="send">Send Message</a></li>
                                        <li><a href="messages?unread=true">Unread Messages</a></li>
                                        <li><a href="message">All Messages</a></li>
                                    </ul>
                                </li>
                                <li class="topmenu"><a href="friends" style="width:98px;"><span>Friends</span></a>
                                    <ul>
                                        <li class="subfirst"><a href="friend?request=true">Requests</a></li>
                                        <li><a href="friend">All Friends</a></li>
                                        <li><a href="#">Bloked List</a></li>
                                    </ul>
                                </li>
                                <li class="topmenu"><a href="photo" style="width:98px;"><span>Photo</span></a>
                                    <ul>
                                        <li class="subfirst"><a href="photo?upload=true">Upload Photo</a></li>
                                        <li><a href="photo">View Photos</a></li>
                                    </ul>
                                </li>
                                <li class="toplast"><a href="notification" style="width:98px;">Notification</a></li>
                            </ul>
                        </nav>
                    </td>
                    <td>
                        <div id="content">
                            <div class="post" style="text-align: center; width: 500px">
                                <form action="home.jsp" method="POST">
                                    <textarea name="txt" cols="25" rows="3"></textarea>
                                    <input type="submit" value="Post" style="vertical-align: bottom"/>
                                </form>
                            </div>

                            <%

                            %>

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
