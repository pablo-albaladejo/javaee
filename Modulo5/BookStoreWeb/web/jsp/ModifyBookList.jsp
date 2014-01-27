<%-- 
    Document   : ManageDDBB
    Created on : 19-dic-2013, 19:47:22
    Author     : Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <%@ include file="/jsp/header.jsp" %>
     <script language="JavaScript" type="text/javascript">
        function deleteBook(ISBN){
            var myForm = createForm("./ModifyBookList.do","POST");
            
            myForm.appendChild(createActionControl("action","DELETE_BOOK"));
            myForm.appendChild(createActionControl("ISBN",ISBN));
    
            document.body.appendChild(myForm);
            myForm.submit();
        }
        
        function editBook(ISBN){
            var myForm = createForm("./ModifyBookList.do","POST");
            
            myForm.appendChild(createActionControl("action","EDIT_BOOK"));
            myForm.appendChild(createActionControl("ISBN",ISBN));
            
            document.body.appendChild(myForm);
            myForm.submit();
        }       
    </script>
    </head>
    <body>
        <h1>Manage DDBB</h1>
        <c:if test="${not empty requestScope.message}">
        <p class ="message">${requestScope.message}</p>
        </c:if>
        <h2>Modify Book list</h2>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Editorial</th>
                <th>ISBN</th>
                <th>Publication Year</th>
                <th>Price</th>
                <th>Descripcion</th>
                <th>Edit</th>
                <th>Remove</th>
            </tr>
            <c:forEach var="book" items="${requestScope.list}" varStatus="counter" >
                <c:choose>
                <c:when test="${counter.count mod 2 == 0 || counter.count == 0}">
                <tr class ="even">
                </c:when>
                <c:otherwise>
                <tr class ="odd">
                </c:otherwise>
                </c:choose>
                    <input type="hidden" name="ISBN" value ="<jsp:getProperty name="book" property="ISBN" />"/>
                    <td><jsp:getProperty name="book" property="title" /></td>
                    <td><jsp:getProperty name="book" property="author" /></td>
                    <td><jsp:getProperty name="book" property="editorial" /></td>
                    <td><jsp:getProperty name="book" property="ISBN" /></td>
                    <td><jsp:getProperty name="book" property="publicationYear" /></td>
                    <td><jsp:getProperty name="book" property="price" /></td>
                    <td><jsp:getProperty name="book" property="description" /></td>
                    <td><input type="button" onClick="editBook('<jsp:getProperty name="book" property="ISBN" />')" class="editBook"/></td>
                    <td><input type="button" onClick="deleteBook('<jsp:getProperty name="book" property="ISBN" />')" class="removeBook"/></td>
                </tr>
            </c:forEach>
        </table>
        <%@ include file="/jsp/footer.jsp" %>
    </body>
</html>
