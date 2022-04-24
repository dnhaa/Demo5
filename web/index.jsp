<%-- 
    Document   : index
    Created on : Apr 15, 2022, 1:06:16 PM
    Author     : ACER
--%>

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
