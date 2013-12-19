<%-- 
    Document   : ManageDDBB
    Created on : 19-dic-2013, 19:47:22
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="/jsp/header.jsp" %>
    </head>
    <body>
        <h1>Manage DDBB</h1>
        <h2>Modify Book list</h2>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Editorial</th>
                <th>ISBN</th>
                <th>Publication Year</th>
                <th>Price</th>
                <th>Descripcion</th>
                <th>Edit</th>
                <th>Remove</th>
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
                    <td><img src="./rsc/images/cart_add.png" onClick="sendByPOSTParameter('./ViewCart.do', 'addItem', <jsp:getProperty name="book" property="ISBN" />);"/></td>
                </tr>
                </c:forEach>
        </table>
        <h2>Insert new Book</h2>
        <form>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Editorial</th>
                    <th>ISBN</th>
                    <th>Publication Year</th>
                    <th>Price</th>
                    <th>Descripcion</th>
                    <th>Add</th>
                </tr>
                <tr class ="odd">
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><img src="./rsc/images/cart_add.png" onClick="sendByPOSTParameter('./ViewCart.do', 'addItem', '');"/></td>
                </tr>
            </table>
        </form>
        <%@ include file="/jsp/footer.jsp" %>
    </body>
</html>
