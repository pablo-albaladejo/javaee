<%-- 
    Document   : ManageDDBB
    Created on : 19-dic-2013, 19:47:22
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
        <h1><bean:message key="manage_ddbb"/></h1>
        <h2><bean:message key="modify_book_list"/></h2>
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
                <th><bean:message key="remove"/></th>
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
                    <input type="hidden" name="ISBN" value ="<jsp:getProperty name="book" property="ISBN" />"/>
                    <td><jsp:getProperty name="book" property="title" /></td>
                    <td><jsp:getProperty name="book" property="author" /></td>
                    <td><jsp:getProperty name="book" property="editorial" /></td>
                    <td><jsp:getProperty name="book" property="ISBN" /></td>
                    <td><jsp:getProperty name="book" property="publicationYear" /></td>
                    <td><jsp:getProperty name="book" property="price" /></td>
                    <td><jsp:getProperty name="book" property="description" /></td>
                    <td><input type="button" onClick="editBook('<jsp:getProperty name="book" property="ISBN" />')" class="editBook"/></td>
                    <td><input type="button" onClick="deleteBook('<jsp:getProperty name="book" property="ISBN" />')" class="removeBook"/></td>
                </tr>
            </c:forEach>
        </table>