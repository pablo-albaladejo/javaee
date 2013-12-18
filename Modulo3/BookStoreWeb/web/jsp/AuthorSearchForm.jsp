<%-- 
    Document   : AuthorSearchForm
    Created on : 18-dic-2013, 17:41:43
    Author     : palbaladejo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="list" scope="request" class="java.util.ArrayList" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
        <link href="./css/styles.css" rel="stylesheet" type="text/css" media="screen"/>
        <script type="text/javascript">
            function f_SearchByAuthor(name){
                document.getElementById("controller").action="SearchByAuthor.do";
                document.getElementById("authorName").value = name;
                document.getElementById("controller").submit();
                return;
            }
        </script>
    </head>
    <body>
        <p>Choose an Author:</p>
        <form id="controller" method="POST">
            <input type="hidden" id="authorName" name="authorName"/>
        </form>
        <select id="authors" onChange="f_SearchByAuthor(this.options[this.selectedIndex].innerHTML);"> 
            <option value="0"/>
            <c:forEach var="name" items="${list}">
                <option value="author">${name}</option>
            </c:forEach>
        </select>
        <form action="./">
            <input type="submit" value="Back"></input>
        </form>
    </body>
</html>
