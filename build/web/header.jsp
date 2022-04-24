<%-- 
    Document   : header
    Created on : Apr 15, 2022, 12:41:06 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header style="background-color: pink; height: 100px">
            <nav>
                <a href="index.jsp">Home</a>
                <a href="loginPage.jsp">Login</a>
                <a href="registerPage.jsp">Register</a>
                <a href="viewCartPage.jsp">View cart</a>
        <form action="MainController" method="POST">
            <input type="text" name="txtsearch" value="<%= (request.getParameter("name") != null) ? request.getParameter("name") : ""  %>" />
            <input type="submit" value="GO" name="action"/>
        </form>
            </nav>
        </header>
    </body>
</html>
