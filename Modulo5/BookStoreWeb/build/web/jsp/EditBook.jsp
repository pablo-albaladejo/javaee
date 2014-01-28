<%-- 
    Document   : EditBook
    Created on : 23-ene-2014, 16:55:29
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<jsp:useBean id="book" scope="request" class="bookstore.logic.bean.book.BookBean" />
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/jsp/header.jsp" %>
        <html:javascript formName="BookValidatorForm" />
    </head>
    <body>
        <h1><bean:message key="manage_ddbb"/></h1>
        <c:if test="${not empty requestScope.message}">
        <p class ="message">${requestScope.message}</p>
        </c:if>
        <h2><bean:message key="edit_book"/></h2>
        <html:form action="EditBook" onsubmit="return validateBookValidatorForm(this);" >
            <input type="hidden" name="action" value="EDIT_BOOK"/>
            <input type="hidden" name="ISBN" value="${book.ISBN}"/>
            <table>
                <tr>
                    <th><bean:message key="title"/></th>
                    <th><bean:message key="author"/></th>
                    <th><bean:message key="editorial"/></th>
                    <th><bean:message key="ISBN"/></th>
                    <th><bean:message key="publicationYear"/></th>
                    <th><bean:message key="price"/></th>
                    <th><bean:message key="description"/></th>
                    <th><bean:message key="edit"/></th>
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

