<%-- 
    Document   : managePlantPage
    Created on : Apr 21, 2022, 10:48:51 AM
    Author     : ACER
--%>

<%@page import="dto.Account"%>
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
    </head>
    <body>
        <h1>Manage Plant</h1>
        <h2>Search Plants</h2>
        <form action="MainController">
            <input type="text" name="txtname" value="<%= (request.getAttribute("name") != null) ? request.getAttribute("name") : "" %>" />
            <input type="submit" value="search plants" name="action" />
            <script>
                function myinvalidate(){
                    pname = f.pname.value;
                    //test name
                    if (pname.length == 0){
                        document.getElementById("e1").innerHTML="Input a name";
                        return false;
                    } else {
                        document.getElementById("e1").innerHTML="";
                    }
                    return true;
                }
            </script>
        </form>
        <%
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
                            <td><%= dto.getCatename()%></td>
                            <td><a href="MainController?action=editPlant&id=<%= dto.getPid() %>&txtSearch=<%= request.getAttribute("name") %>" />Edit</td>
                        </tr>
                    <%
                    }
                    %>
                </table>
        <%
            }
        %>
        <h2>Create a new plant</h2>
        <form action="MainController" method="POST" name="f">
            <p>Name <input type="text" name="pname" value="" /> <span id="e1"></span> </p>
            <p>Price <input type="text" name="price" value="" /> </p>
            <p>Image <input type="file" name="imgpath" /> </p>
            <p>Description <input type="text" name="description" value="" /> </p>
            <p>Status <select name="status">
                <option value="1">Active</option>
                <option value="2">Inactive</option>
            </select> </p>
            <p>Category <select name="cateid">
                <option value="1">Orchid</option>
                <option value="2">Roses</option>
                <option value="3">Others</option>
            </select> </p>
            <input type="submit" value="create plant" name="action" />
        </form>
        
    </body>
</html>
    <%
    }
    %>
