<%-- 
    Document   : managePlantPage
    Created on : Apr 21, 2022, 10:48:51 AM
    Author     : ACER
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="acc" value="${sessionScope.acc}" />
<c:if test="${empty acc || acc.role != 1}">
    <c:redirect url="index.jsp" />
</c:if>
<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <!--khuc nay chua chay dc-->
    <c:if test="${not empty param.warning}">
        <script>
            alert("Plant added successfully")
        </script>
    </c:if>
    

    <c:set var="acc" value="${sessionScope.acc}"/>
    <c:if test="${not empty acc}">

    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Plant Page</title>
        <script>
                function myinvalidate(){
                    var invalid = 0;
                    pname = f.pname.value;
                    price = f.price.value;
                    pattern=/^[A-z0-9\s]{1,}$/;
                    pattern1=/^[0-9]{1,}$/;
                    //test name
                    if (!pattern.test(pname)){
                        document.getElementById("e1").innerHTML="Input a name";
                        invalid ++;
                    } else {
                        document.getElementById("e1").innerHTML="";
                    }
                    if (!pattern1.test(price)){
                        document.getElementById("e2").innerHTML="Input a price";
                        invalid ++;
                    } else {
                        document.getElementById("e2").innerHTML="";
                    }
                    if (invalid > 0){
                        return  false;
                    }
                    return true;
                }
            </script>
            <style>
                span{
                    color: red;
                }
            </style>
    </head>
    <body>
        <h1>Manage Plant</h1>
        <h2>Search Plants</h2>
        <form action="MainController">
            <input type="text" name="txtname" value="${not empty requestScope.name ? requestScope.name : ""}" />
            <input type="submit" value="search plants" name="action" />
            
        </form>
            <c:if test="${not empty requestScope.name}">
                <c:set var="list" value="${requestScope.list}" />
                <c:if test="${not empty list}">
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Category</th>
                            <th>Action</th>
                        </tr>

                        <c:forEach var="p" items="${list}">
                            <tr>
                                <td>${p.pid}</td>
                                <td>${p.pname}</td>
                                <td>${p.price}</td>
                                <td><img src="${p.imgpath}" style="width: 170px; height: 100px;"></td>
                                <td>${p.description}</td>
                                <td>${p.status}</td>
                                <td>${p.catename}</td>
                                <td><a href="MainController?action=editPlant&id=${p.pid}&txtSearch=${requestScope.name}" />Edit</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${empty list}">
                    <h2>No plant found</h2>
                </c:if>
            </c:if>
            
            <h2>Create a new plant</h2>
            <form action="MainController" method="POST" name="f">
                <p>Name <input type="text" name="pname" value="" /> <span id="e1"></span> </p>
                <p>Price <input type="text" name="price" value="" /> <span id="e2"></span> </p>
                <p>Image <input type="file" name="imgpath" /> </p>
                <p>Description <input type="text" name="description" value="" /> </p>
                <p>Status <select name="status">
                    <option value="1">Active</option>
                    <option value="0">Inactive</option>
                </select> </p>
                <p>Category <select name="cateid">
                    <option value="1">Orchid</option>
                    <option value="2">Roses</option>
                    <option value="3">Others</option>
                </select> </p>
                <input type="submit" value="create plant" name="action" onclick="return myinvalidate()"/>
            </form>
            
    </body>
</html>
</c:if>
<c:if test="${empty acc}">
    <jsp:forward page="index.jsp" />
</c:if>







<%--<%@page import="dto.Account"%>
<%@page import="dto.Plant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Account acc = (Account)session.getAttribute("acc");
    if (acc == null){
        response.sendRedirect("index.jsp");
    } else {
        
    
    String msg = request.getParameter("warning");
    if (msg != null){
        if (msg.equals("createPlantSuccess")){
            %>
            <script>
                alert("Planted Added Successfully");
            </script>
    <%
        } if (msg.equals("createPlantFail")){
            %>
            <script>
                alert("Fail to add plant");
            </script>
    <%
        }
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Plant Page</title>
        <script>
                function myinvalidate(){
                    var invalid = 0;
                    pname = f.pname.value;
                    price = f.price.value;
                    pattern=/^[A-z0-9]{1,}$/;
                    pattern1=/^[0-9]{1,}$/;
                    //test name
                    if (!pattern.test(pname)){
                        document.getElementById("e1").innerHTML="Input a name";
                        invalid ++;
                    } else {
                        document.getElementById("e1").innerHTML="";
                    }
                    if (!pattern1.test(price)){
                        document.getElementById("e2").innerHTML="Input a price";
                        invalid ++;
                    } else {
                        document.getElementById("e2").innerHTML="";
                    }
                    if (invalid > 0){
                        return  false;
                    }
                    return true;
                }
            </script>
    </head>
    <body>
        <h1>Manage Plant</h1>
        <h2>Search Plants</h2>
        <form action="MainController">
            <input type="text" name="txtname" value="<%= (request.getAttribute("name") != null) ? request.getAttribute("name") : "" %>" />
            <input type="submit" value="search plants" name="action" />
            
        </form>
        <%
            if (request.getAttribute("name") != null){
                ArrayList<Plant> list = (ArrayList<Plant>)request.getAttribute("list");
                if (list != null && list.size() > 0){
                    %>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Category</th>
                            <th>Action</th>
                        </tr>

                        <%
                        for (Plant dto : list){
                            %>
                            <tr>
                                <td><%= dto.getPid() %></td>
                                <td><%= dto.getPname()%></td>
                                <td><%= dto.getPrice()%></td>
                                <td><img src="<%= dto.getImgpath() %>" style="width: 170px; height: 100px;"</td>
                                <td><%= dto.getDescription() %></td>
                                <td><%= dto.getStatus()%></td>
                                <td><%= dto.getCatename()%></td>
                                <td><a href="MainController?action=editPlant&id=<%= dto.getPid() %>&txtSearch=<%= request.getAttribute("name") %>" />Edit</td>
                            </tr>
                        <%
                        }
                        %>
                    </table>
            <%
                } else {
                    %>
                    <h2>No result found</h2>
        <%
                }
            }
            %>
            
           
            
            
        <h2>Create a new plant</h2>
        <form action="MainController" method="POST" name="f">
            <p>Name <input type="text" name="pname" value="" /> <span id="e1"></span> </p>
            <p>Price <input type="text" name="price" value="" /> <span id="e2"></span> </p>
            <p>Image <input type="file" name="imgpath" /> </p>
            <p>Description <input type="text" name="description" value="" /> </p>
            <p>Status <select name="status">
                <option value="1">Active</option>
                <option value="0">Inactive</option>
            </select> </p>
            <p>Category <select name="cateid">
                <option value="1">Orchid</option>
                <option value="2">Roses</option>
                <option value="3">Others</option>
            </select> </p>
            <input type="submit" value="create plant" name="action" onclick="return myinvalidate()"/>
        </form>
        <br/><a href="adminPage.jsp">Go back to Admin Page</a>
    </body>
    
</html>
    <%
    }
    %>--%>
