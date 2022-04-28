<%-- 
    Document   : editPlantPage
    Created on : Apr 22, 2022, 9:07:49 AM
    Author     : ACER
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tlds/mytag" prefix="ha"%>

<c:set var="acc" value="${sessionScope.acc}" />
<c:if test="${empty acc || acc.role != 1}">
    <c:redirect url="index.jsp" />
</c:if>

<jsp:include page="header.jsp" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Plant Page</title>
        <script>
            function validation(){
                var invalid = 0;
                pname=f.pname.value;
                price=f.price.value;
                pattern=/^[A-z0-9\s]{1,}$/;
                pattern1=/^[0-9]{1,}$/;

                //test name
                if (!pattern.test(pname)){
                    document.getElementById("e1").innerHTML="Name is invalid";
                    invalid ++;
                } else {
                    document.getElementById("e1").innerHTML="";
                }
                //test price
                if (!pattern1.test(price)){
                    document.getElementById("e2").innerHTML="Price has to be a number";
                    invalid ++;
                } else {
                    document.getElementById("e2").innerHTML="";
                }
                if (invalid > 0)
                    return false;
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
        <h1>Edit Plant Page</h1>
        
        <c:set var="id" value="${param.id}"/>
        <ha:getOnePlant pid="${id}"></ha:getOnePlant>
        <c:set var="p" value="${ p }" />
        <c:if test="${not empty p}">
            <form action="MainController" name="f">
                    <input type="hidden" name="txtSearch" value="<%= request.getParameter("txtSearch") %>" />
                    <p>Id: ${p.pid} </p>
                    <input type="hidden" name="pid" value="${p.pid}" />
                    <p>Name <input type="text" name="pname" value="${p.pname}" /> <span id="e1"></span> </p>
                    <p>Price <input type="text" name="price" value="${p.price}" /> <span id="e2"></span> </p>
                    <input type="hidden" name="imgpathOriginal" value="${p.imgpath}" />
                    <p>Image <input type="file" name="imgpath" /> </p>
                    <p>Description <input type="text" name="description" value="${p.description}" /> </p>
                    <p>Status <select name="status">
                            <option value="1">Active</option>
                            <option value="0">Inactive</option>
                        </select> </p>
                    <p>Category <select name="cateid">
                            <option value="1">Orchid</option>
                            <option value="2">Roses</option>
                            <option value="3">Others</option>
                        </select> </p>
                        <input type="submit" value="edit" name="action" onclick="return validation()"/>
                </form>
        </c:if>
        <br/><a href="managePlantPage.jsp">Go back to Manage Page</a>
        
    </body>
</html>














<%--
<%@page import="dao.PlantDao"%>
<%@page import="dto.Plant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Plant Page</title>
        <script>
            function validation(){
                var invalid = 0;
                pname=f.pname.value;
                price=f.price.value;
                pattern=/^[A-z0-9]{1,}$/;
                pattern1=/^[0-9]{1,}$/;

                //test name
                if (!pattern.test(pname)){
                    document.getElementById("e1").innerHTML="Name is invalid";
                    invalid ++;
                } else {
                    document.getElementById("e1").innerHTML="";
                }
                //test price
                if (!pattern1.test(price)){
                    document.getElementById("e2").innerHTML="Price has to be a number";
                    invalid ++;
                } else {
                    document.getElementById("e2").innerHTML="";
                }
                if (invalid > 0)
                    return false;
                return true;
            
            }
        </script>
    </head>
    <body>
        <h1>Edit Plant Page</h1>
        <%
            String id = request.getParameter("id");
            Plant p = PlantDao.getPlant(new Integer(id));
            if (p != null){
                %>
                <form action="MainController" name="f">
                    <input type="hidden" name="txtSearch" value="<%= request.getParameter("txtSearch") %>" />
                    <p>Id: <%= p.getPid() %> </p>
                    <input type="hidden" name="pid" value="<%= p.getPid() %>" />
                    <p>Name <input type="text" name="pname" value="<%= p.getPname()%>" /> <span id="e1"></span> </p>
                    <p>Price <input type="text" name="price" value="<%= p.getPrice()%>" /> <span id="e2"></span> </p>
                    <input type="hidden" name="imgpathOriginal" value="<%= p.getImgpath()%>" />
                    <p>Image <input type="file" name="imgpath" /> </p>
                    <p>Description <input type="text" name="description" value="<%= p.getDescription()%>" /> </p>
                    <p>Status <select name="status">
                            <option value="1">Active</option>
                            <option value="0">Inactive</option>
                        </select> </p>
                    <p>Category <select name="cateid">
                            <option value="1">Orchid</option>
                            <option value="2">Roses</option>
                            <option value="3">Others</option>
                        </select> </p>
                        <input type="submit" value="edit" name="action" onclick="return validation()"/>
                </form>
        <%
            }
        %>
        
    </body>
</html>
--%>