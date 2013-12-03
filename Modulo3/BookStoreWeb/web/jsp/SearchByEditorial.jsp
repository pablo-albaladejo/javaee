<%-- 
    Document   : SearchByEdirorial
    Created on : 03-dic-2013, 21:28:57
    Author     : <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
        <script src="../js/XHR.js" type="text/javascript"></script>
        <script type="text/javascript">
                function searchEditorial(name){
                    if(name === undefined){
                        sendRequest('SearchByEditorial', null);
                    }else{
                        sendRequest('SearchByEditorial', new Array(new Param('name',name)));
                    }
                }        
        </script>
    </head>
    <body onLoad="searchEditorial();" >
        <div id="content">  
        </div>
    </body>
</html>
