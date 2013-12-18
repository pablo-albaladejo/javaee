<%-- 
    Document   : SearchAllBooks
    Created on : 02-dic-2013, 23:23:11
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="book" class="bookstore.logic.bean.book.BeanBook" />
<jsp:useBean id="list" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="author" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Book Store</title>
        <link href="./css/styles.css" rel="stylesheet" type="text/css" media="screen"/>
    </head>
    <body>
        <c:if test="${not empty author}">
        <h1>${author}</h1>
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
            </tr>
            <c:forEach var="book" items="${list}" varStatus="counter" >
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
            </tr>
            </c:forEach>
        </table>
        <form action="./">
            <input type="submit" value="Back"></input>
        </form>
    </body>
</html>
