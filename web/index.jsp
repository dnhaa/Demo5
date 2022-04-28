<%-- 
    Document   : index
    Created on : Apr 15, 2022, 1:06:16 PM
    Author     : ACER
--%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytag" prefix="ha"%>

<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
         <c:if test="${not empty param.warning}">
            <script>
                alert("1 san pham da duoc them vao gio hang");
            </script>
        </c:if>
        <table cellspacing="5">
           
            <c:set var="list" value="${requestScope.listAccounts}" />
            <c:if test="${not empty list}">
                 <tr>
                    <th>Id</th>
                    <th>Password</th>
                    <th>Email</th>
                    <th>Full name</th>
                    <th>Phone</th>
                    <th>Status</th>
                    <th>Role</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="acc" items="${list}">
                    <tr>
                        <td>${acc.accid}</td>
                        <td>${acc.password}</td>
                        <td>${acc.email}</td>
                        <td>${acc.fullname}</td>
                        <td>${acc.phone}</td>
                        <td>${acc.status}</td>
                        <td>${acc.role}</td>
                        <td>
                            <c:if test="${acc.role != 1}">
                                <a href="UpdateStatusServlet?accid=${acc.accid}&oldstatus=${acc.status}">Block/Unblock</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
    </table>

    <c:if test="${empty list and !empty requestScope.txtsearch}">
        <h3>No record found</h3>
    </c:if>
    <ha:getAllPlants></ha:getAllPlants>
    <c:set var="plantList" value="${plantList}"/>
    <c:if test="${not empty plantList}">
        <c:forEach var="p" items="${plantList}">
            <table>
                <tr>
                    <td rowspan="4"><img src="${p.imgpath}" style="width: 170px; height: 100px" /></td>
                    <td>${p.pid}</td>
                </tr>
                <tr>
                    <td>${p.pname}</td>
                </tr>
                <tr>
                    <td>${p.price}</td>
                </tr>
                <tr>
                    <td><a href="MainController?action=addtocart&id=${p.pid}">Add to cart</a></td>
                </tr>
            </table>
        </c:forEach>
    </c:if>






<%--
<%@page import="dao.PlantDao"%>
<%@page import="dto.Plant"%>
<%@page import="dto.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorLocalPage.jsp" %>
<!--chen header.jsp-->
<%@include file="header.jsp" %>
<%
    //check co parameter warning=thanhcon nhan dc tu trang addToCart.servlet
    String msg = request.getParameter("warning");
    if (msg != null){
        %>
        <script>
            alert("1 san pham da dc them vao gio hang");
        </script>
        <%
    }
    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table cellspacing="5">
            <tr>
                <th>Id</th>
                <th>Password</th>
                <th>Email</th>
                <th>Full name</th>
                <th>Phone</th>
                <th>Status</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
        <%
            ArrayList<Account> list = (ArrayList) request.getAttribute("listAccounts");
            
            if (list != null && list.size() > 0){
                for (Account acc : list){
                    %>
                        <tr>
                            <td><%= acc.getAccid() %></td>
                            <td><%= acc.getPassword()%></td>
                            <td><%= acc.getEmail()%></td>
                            <td><%= acc.getFullname()%></td>
                            <td><%= acc.getPhone()%></td>
                            <td><%= acc.getStatus()%></td>
                            <td><%= acc.getRole()%></td>
                            <td>
                                <% if(acc.getRole() != 1){%>
                                    <a href="UpdateStatusServlet?accid=<%= acc.getAccid() %>&oldstatus=<%= acc.getStatus()%>">Block/Unblock</a>
                                <%}%>
                                
                            </td>
                        </tr>
                    
                    <%
                }
            } else {
                if (request.getAttribute("flag") != null){
                    out.println("<h3>Nothing</h3>");
                }
            }
        %>
        </table>
        
        <%
            ArrayList<Plant> list2 = PlantDao.getPlants();
            if (list2 != null && list2.size() > 0){
                for (Plant p : list2){
                    %>
                    <table>
                        <tr>
                            <td rowspan="4"><img src="<%= p.getImgpath() %>" style="width: 170px; height: 100px" /></td>
                            <td><%= p.getPid() %></td>
                        </tr>
                        <tr>
                            <td><%= p.getPname()%></td>
                        </tr>
                        <tr>
                            <td><%= p.getPrice()%></td>
                        </tr>
                        <tr>
                            <td><a href="MainController?action=addtocart&id=<%= p.getPid() %>">Add to cart</a></td>
                        </tr>
                    </table>
                    <%
                }
            }
        %>
        
    </body>
</html>
--%>