<%-- 
    Document   : SearchByTitleForm
    Created on : 19-dic-2013, 16:16:38
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="header.jsp" %>
    </head>
    <body>
        <p>Write a Title</p>
        <form action = "./SearchByTitle.do" method="POST">
            <input type="text" name="title"/>
            <input type="submit" value="Search"/>
        </form>
        <%@ include file="footer.jsp" %>
    </body>
    </body>
</html>
