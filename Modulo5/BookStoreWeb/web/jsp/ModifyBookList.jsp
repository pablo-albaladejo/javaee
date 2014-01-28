<%-- 
    Document   : ModifyBookList
    Created on : 28-ene-2014, 20:22:58
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<tiles:insert page="/jsp/template.jsp" flush="true">
    <tiles:put name="header" value="/jsp/header.jsp"/>
    <tiles:put name="content" value="/jsp/ModifyBookList_content.jsp"/>
    <tiles:put name="footer" value="/jsp/footer.jsp"/>
</tiles:insert>
