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
        function addBook(formName){            
            document.getElementById(formName).submit();   
        }
        function deleteBook(ISBN){
            var myForm = createForm("./ManageDDBB.do","POST");
            
            myForm.appendChild(createActionControl("action","DELETE_BOOK"));
            myForm.appendChild(createActionControl("ISBN",ISBN));
    
            document.body.appendChild(myForm);
            myForm.submit();
        }
        
        function editBook(ISBN){
            var myForm = createForm("./ManageDDBB.do","POST");
            
            myForm.appendChild(createActionControl("action","EDIT_BOOK"));
            myForm.appendChild(createActionControl("ISBN",ISBN));
            myForm.appendChild(createActionControl("title",document.getElementById("title_"+ISBN).value));
            myForm.appendChild(createActionControl("author",document.getElementById("author_"+ISBN).value));
            myForm.appendChild(createActionControl("editorial",document.getElementById("editorial_"+ISBN).value));
            myForm.appendChild(createActionControl("publicationYear",document.getElementById("publicationYear_"+ISBN).value));
            myForm.appendChild(createActionControl("price",document.getElementById("price_"+ISBN).value));    
            myForm.appendChild(createActionControl("description",document.getElementById("description_"+ISBN).value));
            
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
                    <td><input type="text" name="title"  id="title_<jsp:getProperty name="book" property="ISBN" />" value="<jsp:getProperty name="book" property="title" />"/></td>
                    <td><input type="text" name="author" id="author_<jsp:getProperty name="book" property="ISBN" />" value="<jsp:getProperty name="book" property="author" />"/></td>
                    <td><input type="text" name="editorial" id="editorial_<jsp:getProperty name="book" property="ISBN" />" value="<jsp:getProperty name="book" property="editorial" />"/></td>
                    <td><jsp:getProperty name="book" property="ISBN" /></td>
                    <td><input type="text" name="publicationYear" id="publicationYear_<jsp:getProperty name="book" property="ISBN" />" value="<jsp:getProperty name="book" property="publicationYear" />"/></td>
                    <td><input type="text" name="price" id="price_<jsp:getProperty name="book" property="ISBN" />" value="<jsp:getProperty name="book" property="price" />"/></td>
                    <td><input type="text" name="description" id="description_<jsp:getProperty name="book" property="ISBN" />" value="<jsp:getProperty name="book" property="description" />"/></td>
                    <td><input type="button" onClick="editBook('<jsp:getProperty name="book" property="ISBN" />')" class="editBook"/></td>
                    <td><input type="button" onClick="deleteBook('<jsp:getProperty name="book" property="ISBN" />')" class="removeBook"/></td>
                </tr>
                </c:forEach>
        </table>
        <h2>Insert new Book</h2>
        <form id="addBook" action="./ManageDDBB.do" method="POST">
            <input type="hidden" name="action" value="ADD_BOOK"/>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Editorial</th>
                    <th>ISBN</th>
                    <th>Publication Year</th>
                    <th>Price</th>
                    <th>Descripcion</th>
                    <th>Add</th>
                </tr>
                <tr class ="odd">
                    <td><input type="text" name="title"/></td>
                    <td><input type="text" name="author"/></td>
                    <td><input type="text" name="editorial"/></td>
                    <td><input type="text" name="ISBN"/></td>
                    <td><input type="text" name="publicationYear"/></td>
                    <td><input type="text" name="price"/></td>
                    <td><input type="text" name="description"/></td>
                    <td><input type="submit" value=" " class="addBook"></td>
                </tr>
            </table>
        </form>
        <%@ include file="/jsp/footer.jsp" %>
    </body>
</html>
