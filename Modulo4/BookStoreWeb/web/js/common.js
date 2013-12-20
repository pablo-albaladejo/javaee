function sendByPOSTParameter(action, parameter, value) {

    var myForm = document.createElement("form");
    myForm.action = action;
    myForm.method = "POST";
    
    var myControl = document.createElement("input");
    myControl.setAttribute("type", "hidden");
    myControl.setAttribute("name", parameter);
    myControl.setAttribute("value", value);
    myForm.appendChild(myControl);
    
    document.body.appendChild(myForm);
    myForm.submit();
}

function sendByPOST(action) {
    var myForm = document.createElement("form");
    myForm.action = action;
    myForm.method = "POST";

    document.body.appendChild(myForm);
    myForm.submit();
}


