<%-- 
    Document   : EditorialSeachForm
    Created on : 19-dic-2013, 15:17:58
    Author     : palbaladejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="list" scope="request" class="java.util.List" />
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="header.jsp" %>
    </head>
    <body>
        <p>Choose an Editorial</p>
        <select id="authors" onChange="sendByPOSTParameter('./SearchByEditorial.do','editorialName',this.options[this.selectedIndex].innerHTML);">
            <option value="0"/>
            <c:forEach var="name" items="${list}">
                <option value="editorial">${name}</option>
            </c:forEach>
        </select>
        <%@ include file="footer.jsp" %>
    </body>
</html>

