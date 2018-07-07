<%@page import="com.bdusn.C.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        // means NOT loged in
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BDUSN | Home</title>
        <link rel="stylesheet" href="css/css3menu1/style.css" type="text/css" />
        <style>
            body {
                background-color: rgb(241,241,241);
                margin: 0px;
            }

            body > header {
                width: 100%;
                height: 50px;
                position: fixed;
                background-image: linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);
                background-image: -o-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);
                background-image: -moz-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);
                background-image: -webkit-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);
                background-image: -ms-linear-gradient(bottom, #3C3C3C 16%, #5A5A5A 58%);

                background-image: -webkit-gradient(
                    linear,
                    left bottom,
                    left top,
                    color-stop(0.16, #3C3C3C),
                    color-stop(0.58, #5A5A5A)
                    );

                margin: 0px;
                top: 0px; /* ear: 25px */
                box-shadow: #666 0px 5px 5px;
            }

            body > header > #headerContent {
                width: 1000px;
                margin: 0px auto;
                height: inherit;
            }

            body > header > #headerContent > #logo {
                left: 10px;
                height: inherit;
                width: 300px;
                float: left;
            }

            body > header > #headerContent > #logo {
                left: 10px;
                height: inherit;
                width: 300px;
                float: left;
            }

            body > header > #headerContent > #search {
                height: 34px;
                width: 300px;
                margin: 8px;
                float: left;
                padding: 3px;
                background-color: #EBEBEB;
                border: #FFF solid 1px;
                border-radius: 5px;
            }

            body > header > #headerContent > #search input{
                background-color: #EBEBEB;
                border: none;
                margin: 0px 3px;
                padding: 0px;
                height: 30px;
                width: 180px;
                vertical-align: middle;
            }

            body > header > #headerContent > #control {
                height: 50px;
                width: auto;
                float: right;
                padding: 6px;
            }
        </style>
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
                    <ul id="css3menu1" class="topmenu">
                        <li class="topfirst"><a href="home.jsp" title="Go to Home Page" style="height:18px;line-height:18px;">Home</a></li>
                        <li class="topmenu"><a href="#" title="Go to your profile" style="height:18px;line-height:18px;">
                                <%=user.getFirstName() + " " + user.getLastName()%>
                            </a>
                        </li>
                        <li class="toplast"><a href="logout.jsp" title="Logout from BDUSN" style="height:18px;line-height:18px;">Logout</a></li>
                    </ul>
                </div>
            </div>
        </header>
        <footer>
            <div style="">

            </div>
        </footer>
    </body>
</html>