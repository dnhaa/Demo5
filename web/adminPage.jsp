<%@taglib uri="/WEB-INF/tlds/mytag" prefix="ha"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="acc" value="${sessionScope.acc}" />
<c:if test="${empty acc || acc.role != 1}">
    <c:redirect url="index.jsp" />
</c:if>

<jsp:include page="header.jsp" />
<!DOCTYPE html>


<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <ha:welcome user="${acc}"/>
        
        <h2><a href="MainController?action=logout">Logout</a></h2>
        <h2><a href="MainController?action=managePlant">Manage Plant</a></h2>
        
    </body>
</html>







<%--
<%
    Account acc2 = (Account) session.getAttribute("acc");
    if (acc2 == null){
        response.sendRedirect("index.jsp");
    } else {
    %>
    <jsp:useBean id="acc" class="dto.Account" scope="session" /> 
    <c:if test="${empty acc || acc.role != 1}">
        <c:redirect url="index.jsp" />
    </c:if>

<!DOCTYPE html>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <ha:welcome user="${acc}"/>
        
        <h2><a href="MainController?action=logout">Logout</a></h2>
        <p><a href="MainController?action=managePlant">Manage Plant</a></p>
        <form>
            <p> <input type="text" name="txtsearch" value="" /> 
                <input type="submit" value="search" /> </p>
        </form>
    </body>
</html>
    <%
    }
%>
--%>