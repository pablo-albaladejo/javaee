<%-- 
    Document   : SearchAllAuthors
    Created on : 02-dic-2013, 18:37:04
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
        <link href="../css/styles.css" rel="stylesheet" type="text/css" media="screen"/>
        <script src="../js/XHR.js" type="text/javascript"></script>
        <script type="text/javascript">
                function searchAuthor(name){
                    if(name === undefined){
                        sendRequest('SearchByAuthor', null);
                    }else{
                        sendRequest('SearchByAuthor', new Array(new Param('name',name)));
                    }
                }        
        </script>
    </head>
    <body onLoad="searchAuthor();" >
        <div id="content">  
        </div>
    </body>
</html>
