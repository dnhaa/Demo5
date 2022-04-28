<%-- 
    Document   : viewCartPage
    Created on : Apr 20, 2022, 11:47:07 AM
    Author     : ACER
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytag" prefix="ha"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <style>
            img{
                width: 170px;
                height: 100px;
            }
            table{ margin: 50px;}
            
            th{
                width: 70px;
            }
            td{
                width: 70px;
            }
             
        </style>
        <script>
            function myconfirm(){
                ans=confirm("co chac bo san pham nay");
                if (ans){
                    return true;
                }
                return false;
            }
        </script>
    </head>
    <jsp:include page="header.jsp"></jsp:include>
    <body>
        <c:set var="cart" value="${sessionScope.cart}" />
        <c:set var="total" value="${ 0 }" />
        <c:if test="${not empty cart}" >
            <c:forEach var="id" items="${cart.keySet()}">
                <ha:getOnePlant pid="${id}"></ha:getOnePlant>
                <c:set var="p" value="${ p }"/>
                <c:if test="${not empty p}">
                    <form action="MainController" method="POST">
                        <table>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>image</th>
                                <th>quantity</th>
                                <th>price</th>
                                <th>action</th>
                            </tr>
                            <tr>
                                <p><input type="hidden" name="id" value="${p.pid}" /></p>
                                <td> ${p.pid} </td>
                                <td> ${p.pname} </td>
                                <td> <img src="${p.imgpath}" /> </td>
                                <td> <input type="text" value="${cart.get(id)}" name="quantity" /> </td>
                                <td> ${p.price} </td>
                                <td> <input type="submit" value="Update quantity" name="action" /> </td>
                                <td> <input type="submit" value="remove" name="action" onclick="return myconfirm()" /> </td>
                            </tr>
                        </table>
                    </form>
                    </c:if>
                <c:set var="total" value="${total + p.price * cart.get(id)}" />
            </c:forEach>
            
        </c:if>
        <h4>Total: ${total} VND</h4>
        <jsp:useBean id="current" class="java.util.Date" />
        <h4>Order date: ${current} </h4>
        <h4>Ship date: du kien giao sau 7 ngay</h4>
        <h4><a href="MainController?action=checkout">Check out</a></h4>
        <c:if test="${not empty param.warning1}">
            <h3 style="color: red">Admin cannot buy product.</h3>
            
        </c:if>
        <c:if test="${not empty param.warning2}">
            <h3 style="color: red">Cart is empty.</h3>
            
        </c:if>
        
        
        



<%--
<%@page import="java.util.Date"%>
<%--<%@page import="java.sql.Date"%>--%>

<%--
<%@page import="dao.PlantDao"%>
<%@page import="dto.Plant"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            img{
                width: 170px;
                height: 100px;
            }
            table{ margin: 50px;}
            
            th{
                width: 70px;
            }
            td{
                width: 70px;
            }
             
        </style>
        <script>
            function myconfirm(){
                ans=confirm("co chac bo san pham nay");
                if (ans){
                    return true;
                }
                return false;
            }
        </script>
    </head>
    <%@include file="header.jsp" %>
    <body>
        <%
            //lay cart obj trong session memory
            HashMap<String, Integer> cart = (HashMap <String, Integer>)session.getAttribute("cart");
            int total = 0;
            if (cart != null && cart.size() > 0){
                
                for (String id : cart.keySet()) {
                        //lay Plant tu db dua vao id
                    Plant p = PlantDao.getPlant(new Integer(id));
                    %>
                    <form action="MainController" method="POST">
                    <table>
                       
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>image</th>
                            <th>quantity</th>
                            <th>price</th>
                            <th>action</th>
                        </tr>
                        <tr>
                            <input type="hidden" name="id" value="<%= p.getPid() %>" />
                            <td> <%= p.getPid() %> </td>
                            <td> <%= p.getPname()%> </td>
                            <td> <img src="<%= p.getImgpath()%>" /> </td>
                            <td> <input type="number" value="<%= cart.get(id) %>" name="quantity" /> </td>
                            <td> <%= p.getPrice()%> </td>
                            <td> <input type="submit" value="Update quantity" name="action" /> </td>
                            <td> <input type="submit" value="remove" name="action" onclick="return myconfirm()" /> </td>
                        </tr>
                    </table>
                    </form>
                    <%
                    total = total + p.getPrice() * cart.get(id);
                    }
            }
        %>
        <h4>Total: <%= total %> VND</h4>
        <h4>Order date: <%= (new Date()).toString() %></h4>
        <h4>Ship date: du kien giao sau 7 ngay</h4>
        <h4><a href="MainController?action=checkout">Check out</a></h4>
    </body>
</html>

--%>