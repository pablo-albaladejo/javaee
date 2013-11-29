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
        <title>JSP Page</title>
        <script src="js/XHR.js" type="text/javascript"></script>
        <script src="js/GUIEvent.js" type="text/javascript"></script>
        <script src="js/BusinessEvent.js" type="text/javascript"></script>
        <script src="js/update.js" type="text/javascript"></script>
        <script type="text/javascript" language="javascript">
              
            function createHTMLTable(names,rows){
                var table = document.createElement("table");
                table.setAttribute("border", "1");
                
                var tr = document.createElement("tr");
                var content = document.createTextNode("value");
                tr.appendChild(content);
                
                table.appendChild(tr);
                return table;
            }
            
            function refreshBooks(books) {
                var div = document.getElementById("bookList");
                if (div) { //already exists -> to be removed from the view
                    div.parentNode.removeChild(div);
                }

                div = document.createElement("div");
                div.setAttribute("id", "bookList");
                
                var names = Array();
                names[0] = "1";
                names[1] = "2";
                names[2] = "3";

                div.appendChild(createHTMLTable(div, names,null));
                alert("yeahhhhhh");
                document.getElementById("content").appendChild(div);
            }
            function loadBooks() {
                update(GUIEvent.SEARCH_ALL_BOOKS, null);
            }
        </script>
    </head>
    <body onLoad="loadBooks();">
        <div id="content">  
        </div>
    </body>
</html>
