<%-- 
    Document   : index
    Created on : 28-nov-2013, 11:51:35
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
        <link href="./css/styles.css" rel="stylesheet" type="text/css" media="screen"/>
        <script language="JavaScript" type="text/javascript">
            function f_searchAllBooks() {
                document.getElementById("controller").action="SearchAllBooks.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_selectAuthor() {
                document.getElementById("controller").action="SearchByAuthor.do";
                document.getElementById("controller").submit();
                return;
            }
        </script>
    <body>
        <div id="content">
            <center>
                <h1>Select one action</h1>
                <form id="controller" method="POST">
                    <input type="submit" value="Search All books" onClick="javascript:f_searchAllBooks();"/>
                    <input type="submit" value="Select Author" onClick="javascript:f_selectAuthor();"/>
                </form>
            <center>
        </diV>
    </body>
</html>
