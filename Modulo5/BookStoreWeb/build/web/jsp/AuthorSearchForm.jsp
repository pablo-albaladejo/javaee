<%-- 
    Document   : AuthorSearchForm
    Created on : 18-dic-2013, 17:41:43
    Author     : palbaladejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<jsp:useBean id="list" scope="request" class="java.util.ArrayList" />
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="header.jsp" %>
    </head>
    <body>
        <p><bean:message key="choose_an_author"/>:</p>
        <select id="authors" onChange="sendByPOSTParameter('./SearchByAuthor.do','authorName',this.options[this.selectedIndex].innerHTML);">
            <option value="0"/>
            <c:forEach var="name" items="${list}">
                <option value="author">${name}</option>
            </c:forEach>
        </select>
        <%@ include file="footer.jsp" %>
    </body>
</html>

