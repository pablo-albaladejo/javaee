<%-- 
    Document   : ISBNSearchForm
    Created on : 19-dic-2013, 16:49:56
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="header.jsp" %>
    </head>
    <body>
        <p>Write a ISBN</p>
        <form action = "./SearchByISBN.do" method="POST">
            <input type="text" name="ISBN"/>
            <input type="submit" value="Search"/>
        </form>
        <%@ include file="footer.jsp" %>
    </body>
    </body>
</html>