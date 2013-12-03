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
    sendXHR(action,getUrlEncodedParams(object));
}

function receiveResponse() {
    if (xhr.readyState === 4) {
       //alert(xhr.responseText);
       document.getElementById("content").innerHTML = xhr.responseText;
    }
}

function sendXHR(action,object) {
    xhr.open("POST", action  + ".do", true);
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

