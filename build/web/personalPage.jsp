<%--<%@page import="dto.Account"%>--%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytag" prefix="ha"%>
<jsp:include page="header.jsp" />
<c:set var="acc" value="${sessionScope.acc}" />
<c:if test="${empty acc}">
    <c:redirect url="index.jsp" />
</c:if>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%--<h2>Welcome <%= ((Account)ses //sion.getAttribute("acc")).getFullname() %> </h2>--%>
        <ha:welcome user="${acc}"/>
        <h2><a href="MainController?action=logout">Logout</a></h2>
        <h1>Purchase History</h1>
        <ha:getAllOrders userid="${acc.accid}"></ha:getAllOrders>
        <c:set var="orderList" value="${orderList}" />
        <c:if test="${not empty orderList}">
            <table border="1">
                <tr>
                    <th>OrderID</th>
                    <th>Order date</th>
                    <th>Ship date</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="o" items="${orderList}">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.orderdate}</td>
                        <td>To be determined</td>
                        <td>Processing</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
