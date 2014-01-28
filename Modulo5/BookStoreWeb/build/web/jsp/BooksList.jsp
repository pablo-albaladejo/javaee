<%-- 
    Document   : SearchAllBooks
    Created on : 02-dic-2013, 23:23:11
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<tiles:insert page="/jsp/template.jsp" flush="true">
    <tiles:put name="header" value="/jsp/header.jsp"/>
    <tiles:put name="content" value="/jsp/BooksList_content.jsp"/>
    <tiles:put name="footer" value="/jsp/footer.jsp"/>
</tiles:insert>