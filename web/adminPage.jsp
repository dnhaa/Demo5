<%@page import="dto.Account"%>
<%
    Account acc = (Account) session.getAttribute("acc");
    if (acc == null){
        response.sendRedirect("index.jsp");
    } else {
    %>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h2>Welcome <%= ((Account)session.getAttribute("acc")).getFullname() %> </h2>
        <h2><a href="MainController?action=logout">Logout</a></h2>
        <p><a href="MainController?action=managePlant">Manage Plant</a></p>
        <form>
            <p> <input type="text" name="txtsearch" value="" /> 
                <input type="submit" value="search" /> </p>
        </form>
    </body>
</html>
    <%
    }
%>
