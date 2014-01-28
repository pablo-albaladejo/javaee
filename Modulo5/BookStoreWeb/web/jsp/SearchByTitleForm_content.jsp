<%-- 
    Document   : SearchByTitleForm
    Created on : 19-dic-2013, 16:16:38
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
        <p><bean:message key="write_a_title"/></p>
        <form action = "./SearchByTitle.do" method="POST">
            <input type="text" name="title"/>
            <input type="submit" value="<bean:message key="search"/>"/>
        </form>