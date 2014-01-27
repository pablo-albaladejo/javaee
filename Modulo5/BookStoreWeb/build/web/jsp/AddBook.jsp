<%-- 
    Document   : AddBook
    Created on : 23-ene-2014, 14:49:39
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/jsp/header.jsp" %>
        <html:javascript formName="BookValidatorForm" />
    </head>
    <body>
        <h1>Manage DDBB</h1>
        <c:if test="${not empty requestScope.message}">
        <p class="message">${requestScope.message}</p>
        </c:if>
        <h2>Insert new Book</h2>
        <html:form action="AddBook" onsubmit="return validateBookValidatorForm(this);" >
            <input type="hidden" name="action" value="ADD_BOOK"/>
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
                    <td><html:text property="title" value=""/></td>
                    <td><html:text property="author" value=""/></td>
                    <td><html:text property="editorial" value=""/></td>
                    <td><html:text property="ISBN" value=""/></td>
                    <td><html:text property="publicationYear" value=""/></td>
                    <td><html:text property="price" value="" /></td>
                    <td><html:text property="description" value=""/></td>
                    <td><html:submit value=" " styleClass ="addBook"  /></td>
                </tr>
            </table>
        </html:form>
        <%@ include file="/jsp/footer.jsp" %>
    </body>
</html>
