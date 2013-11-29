var xhr;

function sendRequest(action, object) {
    // only for Explorer 6 and oldest
    if (window.ActiveXObject)
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    // rest web browsers
    else if ((window.XMLHttpRequest) ||
            (typeof XMLHttpRequest) !== undefined)
        xhr = new XMLHttpRequest();
    // AJAX not supported
    else {
        alert("Your browser does not support AJAX");
        return;
    }
    if(object === null) object = new Array();
    
    object.push(new Param('action',action));
    sendXHR(getUrlEncodedParams(object));
}

function receiveResponse() {
    if (xhr.readyState === 4) {
        var response = xhr.responseXML;
       
       action = parseInt(response.getElementsByTagName("action").item(0).firstChild.nodeValue);
        var object = response.getElementsByTagName("data").item(0);
        
        update(action,object);
    }
}

function sendXHR(object) {
    xhr.open("POST", "client", true);
    xhr.onreadystatechange = receiveResponse;
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.send(object);
}

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

