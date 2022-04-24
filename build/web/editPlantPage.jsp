<%-- 
    Document   : editPlantPage
    Created on : Apr 22, 2022, 9:07:49 AM
    Author     : ACER
--%>

<%@page import="dao.PlantDao"%>
<%@page import="dto.Plant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Plant Page</title>
    </head>
    <body>
        <h1>Edit Plant Page</h1>
        <%
            String id = request.getParameter("id");
            Plant p = PlantDao.getPlant(new Integer(id));
            if (p != null){
                %>
                <form action="MainController">
                    <input type="hidden" name="txtSearch" value="<%= request.getParameter("txtSearch") %>" />
                    <p>Id: <%= p.getPid() %> </p>
                    <input type="hidden" name="pid" value="<%= p.getPid() %>" />
                    <p>Name <input type="text" name="pname" value="<%= p.getPname()%>" /> </p>
                    <p>Price <input type="text" name="price" value="<%= p.getPrice()%>" /> </p>
                    <input type="hidden" name="imgpathOriginal" value="<%= p.getImgpath()%>" />
                    <p>Image <input type="file" name="imgpath" /> </p>
                    <p>Description <input type="text" name="description" value="<%= p.getDescription()%>" /> </p>
                    <p>Status <select name="status">
                            <option value="1">Active</option>
                            <option value="2">Inactive</option>
                        </select> </p>
                    <p>Category <select name="cateid">
                            <option value="1">Orchid</option>
                            <option value="2">Roses</option>
                            <option value="3">Others</option>
                        </select> </p>
                        <input type="submit" value="edit" name="action" />
                </form>
        <%
            }
        %>
        
    </body>
</html>
