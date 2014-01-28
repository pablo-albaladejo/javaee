<%-- 
    Document   : ISBNSearchForm_content
    Created on : 28-ene-2014, 20:20:32
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
        <p><bean:message key="write_a_ISBN"/></p>
        <form action = "./SearchByISBN.do" method="POST">
            <input type="text" name="ISBN"/>
            <input type="submit" value="<bean:message key="search"/>"/>
        </form>
