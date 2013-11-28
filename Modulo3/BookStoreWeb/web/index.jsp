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
        <script src="js/GUIEvent.js" type="text/javascript"></script>
        <script src="js/BusinessEvent.js" type="text/javascript"></script>
        <script type="text/javascript" language="javascript">
            var xhr;

            function Param(name, value) {
                this.name = name;
                this.value = value;
            }

            function getUrlEncodedParams(inputData) {
                var str = "";
                var outputData = new Array();

                for (var i = 0; i < inputData.length; i++) {
                    str = encodeURIComponent(inputData[i].name) + "=";
                    str += encodeURIComponent(inputData[i].value);
                    outputData.push(str);
                }
                str = outputData.join("&");
                return str;
            }

            function sendRequest(action, object) {
                // only for Explorer 6 and oldest
                if (window.ActiveXObject)
                    xhr = new ActiveXObject("Microsoft.XMLHttp");
                // rest web browsers
                else if ((window.XMLHttpRequest) ||
                        (typeof XMLHttpRequest) != undefined)
                    xhr = new XMLHttpRequest();
                // AJAX not supported
                else {
                    alert("Your browser does not support AJAX");
                    return;
                }

                object = new Array();
                object[0] = new Param('action', action);
                object[1] = new Param(2, 2);
                object[2] = new Param(3, 3);
                sendXHR(getUrlEncodedParams(object));
            }

            function sendXHR(object) {

                // preparar la peticion
                xhr.open("POST", "client", true);

                // informar de la funcion que procesara la respuesta
                xhr.onreadystatechange = receiveResponse; // sin parentesis

                xhr.setRequestHeader("Content-Type",
                        "application/x-www-form-urlencoded");
                // enviar la peticion
                xhr.send(object);
            }

            function receiveResponse() {
                // si se ha recibido por completo la respuesta
                if (xhr.readyState == 4) {
                    document.getElementById("testDIV").innerHTML =
                            "<h4 bgcolor='red'>" + xhr.responseText + "</h4>";
                }
            }

            function update(action, object) {
                switch (action) {
                    case GUIEvent.SEARCH_ALL_BOOKS:
                        sendRequest(BusinessEvent.GET_ALL_BOOKS, object);
                        break;

                    default:
                        alert("Error");
                }
            }
        </script>
    </head>
    <body onLoad="update(GUIEvent.SEARCH_ALL_BOOKS, null);">
        <h1>Hello World!</h1>
        <div id="testDIV"/>
    </body>
</html>
