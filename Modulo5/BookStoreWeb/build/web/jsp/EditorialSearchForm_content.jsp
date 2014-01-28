<%-- 
    Document   : EditorialSearchForm_content
    Created on : 28-ene-2014, 20:18:52
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<jsp:useBean id="list" scope="request" class="java.util.ArrayList" />
        <p><bean:message key="choose_an_editorial"/></p>
        <select id="authors" onChange="sendByPOSTParameter('./SearchByEditorial.do','editorialName',this.options[this.selectedIndex].innerHTML);">
            <option value="0"/>
            <c:forEach var="name" items="${list}">
                <option value="editorial">${name}</option>
            </c:forEach>
        </select>
