<%-- 
    Document   : EditBook
    Created on : 23-ene-2014, 16:55:29
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<jsp:useBean id="book" scope="request" class="bookstore.logic.bean.book.BookBean" />
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/jsp/header.jsp" %>
        <html:javascript formName="BookValidatorForm" />
    </head>
    <body>
        <h1>Manage DDBB</h1>
        <c:if test="${not empty requestScope.message}">
        <p class ="message">${requestScope.message}</p>
        </c:if>
        <h2>Edit Book</h2>
        <html:form action="EditBook" onsubmit="return validateBookValidatorForm(this);" >
            <input type="hidden" name="action" value="EDIT_BOOK"/>
            <input type="hidden" name="ISBN" value="${book.ISBN}"/>
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
                </tr>
                <tr class ="odd">
                    <td><html:text property="title" value="${book.title}" /></td>
                    <td><html:text property="author" value="${book.author}"/></td>
                    <td><html:text property="editorial" value="${book.editorial}"/></td>
                    <td>${book.ISBN}</td>
                    <td><html:text property="publicationYear" value="${book.publicationYear}"/></td>
                    <td><html:text property="price" value="${book.price}"/></td>
                    <td><html:text property="description" value="${book.description}"/></td>
                    <td><html:submit value = " " styleClass ="editBook" /></td>
                </tr>
            </table>
        </html:form>
        <%@ include file="/jsp/footer.jsp" %>
    </body>
</html>

