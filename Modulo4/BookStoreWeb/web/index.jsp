<%-- 
    Document   : index
    Created on : 28-nov-2013, 11:51:35
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            function f_selectManageDDBB() {
                document.getElementById("controller").action="ManageDDBB.do";
                document.getElementById("controller").submit();
                return;
            }
        </script>
    <body>
        <div id="content">
            <center>
                <h1>Select one action</h1>
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
                            <td><img src="./rsc/images/cart.png" onClick="sendByPOST('./ViewCart.do');"/></td>
                            <td></td>
                            <td></td>
                        </tr>
                        <tr class="footer">
                            <td>DDBB</td>
                            <td><input type="submit" value="Manage" onClick="javascript:f_selectManageDDBB();"/></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </form>
            <center>
        </diV>
    </body>
</html>
