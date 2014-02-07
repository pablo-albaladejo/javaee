<%-- 
    Document   : SearchAllBooks
    Created on : 02-dic-2013, 23:23:11
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="header.jsp" %>
    </head>
    <body>
        <c:if test="${not empty requestScope.author}">
        <h1>Author: ${requestScope.author}</h1>
        </c:if>
        <c:if test="${not empty requestScope.editorial}">
        <h1>Editorial: ${requestScope.editorial}</h1>
        </c:if>
        <c:if test="${not empty requestScope.title}">
        <h1>Title: ${requestScope.title}</h1>
        </c:if>
        <c:if test="${not empty requestScope.ISBN}">
        <h1>ISBN: ${requestScope.ISBN}</h1>
        </c:if>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Editorial</th>
                <th>ISBN</th>
                <th>Publication Year</th>
                <th>Price</th>
                <th>Descripcion</th>
                <th>Add to Cart</th>
            </tr>
            <c:forEach var="book" items="${requestScope.list}" varStatus="counter" >
            <c:choose>
            <c:when test="${counter.count mod 2 == 0 || counter.count == 0}">
            <tr class ="even">
            </c:when>
            <c:otherwise>
            <tr class ="odd">
            </c:otherwise>
            </c:choose>
                <td><jsp:getProperty name="book" property="title" /></td>
                <td><jsp:getProperty name="book" property="author" /></td>
                <td><jsp:getProperty name="book" property="editorial" /></td>
                <td><jsp:getProperty name="book" property="ISBN" /></td>
                <td><jsp:getProperty name="book" property="publicationYear" /></td>
                <td><jsp:getProperty name="book" property="price" /></td>
                <td><jsp:getProperty name="book" property="description" /></td>
                <td><img src="./rsc/images/cart_add.png" onClick="sendByPOSTParameter('./ViewCart.do', 'addItem', <jsp:getProperty name="book" property="ISBN" />);"/></td>
            </tr>
            </c:forEach>
        </table>
        <%@ include file="footer.jsp" %>
    </body>
</html>
