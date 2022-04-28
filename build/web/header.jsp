<%-- 
    Document   : header
    Created on : Apr 15, 2022, 12:41:06 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <a href="viewCartPage.jsp">View cart</a>
               
                <c:set var="acc" value="${sessionScope.acc}" />
                <c:if test="${not empty acc.accid}">
                    <c:if test="${acc.role == 1}">
                        <a href="adminPage.jsp">Admin Page</a>
                    </c:if>
                    <c:if test="${acc.role != 1}">
                        <a href="personalPage.jsp">Personal Page</a>
                    </c:if>
                </c:if>
                <c:if test="${empty acc.accid}">
                    <a href="loginPage.jsp">Login</a>
                    <a href="registerPage.jsp">Register</a>
                </c:if>
                
                <form action="MainController" method="POST">
                  <%--  <input type="text" name="txtsearch" value="<%= (request.getParameter("name") != null) ? request.getParameter("name") : ""  %>" /> --%>
                    <input type="text" name="txtsearch" value="${param.name}" />
                    <input type="submit" value="GO" name="action"/>
                </form>
            </nav>
        </header>
    </body>
</html>
