<%-- 
    Document   : AddBook
    Created on : 23-ene-2014, 14:49:39
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/jsp/header.jsp" %>
        <html:javascript formName="BookValidatorForm" />
    </head>
    <body>
        <h1><bean:message key="manage_ddbb"/></h1>
        <c:if test="${not empty requestScope.message}">
        <p class="message">${requestScope.message}</p>
        </c:if>
        <h2><bean:message key="insert_new_book"/></h2>
        <html:form action="AddBook" onsubmit="return validateBookValidatorForm(this);" >
            <input type="hidden" name="action" value="ADD_BOOK"/>
            <table>
                <tr>
                    <th><bean:message key="title"/></th>
                    <th><bean:message key="author"/></th>
                    <th><bean:message key="editorial"/></th>
                    <th><bean:message key="ISBN"/></th>
                    <th><bean:message key="publicationYear"/></th>
                    <th><bean:message key="price"/></th>
                    <th><bean:message key="description"/></th>
                    <th><bean:message key="add"/></th>
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
