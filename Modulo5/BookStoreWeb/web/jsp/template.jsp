<%-- 
    Document   : plantilla
    Created on : 28-ene-2014, 19:08:49
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <tiles:insert attribute="header"/>
    </head>
    <body>
        <tiles:insert attribute="content"/>
        <tiles:insert attribute="footer"/>
    </body>
</html>