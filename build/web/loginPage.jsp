<%@include file="header.jsp" %>
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
        <form action="MainController" method="POST">
            <p>email: <input type="text" name="txtemail" value="<%= (request.getAttribute("error")!= null)? request.getAttribute("error") : "" %>" /></p>
            <p>password: <input type="password" name="txtpassword" value="" /></p>
            <p><input type="submit" name="action" value="login" /></p>
        </form>
        <p style="color: red"><%= (request.getAttribute("error")!= null)? request.getAttribute("error") : "" %></p>
    </body>
</html>
