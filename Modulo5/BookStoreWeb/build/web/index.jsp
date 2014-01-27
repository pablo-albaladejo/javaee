<%-- 
    Document   : index
    Created on : 28-nov-2013, 11:51:35
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<jsp:useBean id="BookSuggestion" scope="application" class="java.lang.String"/>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/jsp/header.jsp" %>
        <script language="JavaScript" type="text/javascript">
            function f_searchAllBooks() {
                document.getElementById("controller").action="SearchAllBooks.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_searchTitle() {
                document.getElementById("controller").action="SearchByTitle.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_searchISBN() {
                document.getElementById("controller").action="SearchByISBN.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_selectAuthor() {
                document.getElementById("controller").action="SearchByAuthor.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_selectEditorial() {
                document.getElementById("controller").action="SearchByEditorial.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_AddBook() {
                document.getElementById("controller").action="AddBook.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_ModifyBook() {
                document.getElementById("controller").action="ModifyBookList.do";
                document.getElementById("controller").submit();
                return;
            }
            function f_ViewCart() {
                document.getElementById("controller").action="ViewCart.do";
                document.getElementById("controller").submit();
                return;
            }
        </script>
    </head>
    <body>
        <marquee>
           <bean:message key="book_suggestion"/> : ${BookSuggestion}
        </marquee>
        <div id="content">
            <center>
                <h1><bean:message key="select_one_action"/></h1>
                <form id="controller" method="POST">
                    <table>
                        <tr class="odd">
                            <td>Search</td>
                            <td><input type="submit" value="All books" onClick="javascript:f_searchAllBooks();"/></td>
                            <td><input type="submit" value="Title" onClick="javascript:f_searchTitle();"/></td>
                            <td><input type="submit" value="ISBN" onClick="javascript:f_searchISBN();"/></td>
                        </tr>
                        <tr class="even">
                            <td>Select By</td>
                            <td><input type="submit" value="Author" onClick="javascript:f_selectAuthor();"/></td>
                            <td><input type="submit" value="Editorial" onClick="javascript:f_selectEditorial();"/></td>
                            <td></td>
                        </tr>
                        <tr  class="odd">
                            <td>View Cart</td>
                            <td><input type="submit" value=" " onClick="javascript:f_ViewCart();" class="cart"/></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="footer">
                            <td>DDBB</td>
                            <td><input type="submit" value="Add" onClick="javascript:f_AddBook();"/></td>
                            <td></td>
                            <td><input type="submit" value="Modify" onClick="javascript:f_ModifyBook();"/></td>
                        </tr>
                    </table>
                </form>
            <center>
        </diV>
    </body>
</html>
