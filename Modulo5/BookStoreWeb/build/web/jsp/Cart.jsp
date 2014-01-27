<%-- 
    Document   : Cart
    Created on : 19-dic-2013, 11:10:56
    Author     : palbaladejo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="myCart" scope="session" class="bookstore.logic.bean.cart.CartBean" />
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="header.jsp" %>
    </head>
    <body>
        <h1>My Cart</h1>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Editorial</th>
                <th>ISBN</th>
                <th>Price</th>
                <th>Remove from Cart</th>
            </tr>
            <c:forEach var="book" items="${sessionScope.myCart.list}" varStatus="counter" >
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
                <td><jsp:getProperty name="book" property="price" /></td>
                <td><input type="submit" value=" " class="removeCart" onClick="sendByPOSTParameter('./ViewCart.do', 'removeItem', <jsp:getProperty name="book" property="ISBN" />);"/></td>
            </tr>
            </c:forEach>
        </table>
        <table>
            <tr class ="footer">
                <td>Items</td><td><jsp:getProperty name="myCart" property="itemCount" /></td>
                <td>Total</td><td><jsp:getProperty name="myCart" property="price" /></td>
            </tr>
        </table>
        <%@ include file="footer.jsp" %>
    </body>
</html>
