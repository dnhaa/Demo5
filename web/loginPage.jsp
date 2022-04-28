<%--<%@include file="header.jsp" %>--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<jsp:include page="header.jsp" />

<html>
    <head>
        <title>Admin Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <c:if test="${not empty param.warning}">
            <h3 style="color: red">Login to checkout</h3>
        </c:if>
        <form action="MainController" method="POST">
            <p>email: <input type="text" name="txtemail" value="${ not empty requestScope.email ? requestScope.email : "" }" /></p>
            <p>password: <input type="password" name="txtpassword" value="" /></p>
            <p><input type="submit" name="action" value="login" /></p>
        </form>
            <p style="color: red">${not empty requestScope.error ? requestScope.error : ""}</p>
    </body>
</html>



<%-- <html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="MainController" method="POST">
            <p>email: <input type="text" name="txtemail" value="<%= (request.getAttribute("email")!= null)? request.getAttribute("email") : "" %>" /></p>
            <p>password: <input type="password" name="txtpassword" value="" /></p>
            <p><input type="submit" name="action" value="login" /></p>
        </form>
        <p style="color: red"><%= (request.getAttribute("error")!= null)? request.getAttribute("error") : "" %></p>
    </body>
</html>--%>
