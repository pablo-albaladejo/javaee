function sendByPOSTParameter(action, parameter, value) {
    var myForm = createForm(action,"POST");
    var myControl = createActionControl(parameter,value);
    myForm.appendChild(myControl);
    document.body.appendChild(myForm);
    myForm.submit();
}

function sendByPOST(action) {
    var myForm = createForm(action,"POST");
    document.body.appendChild(myForm);
    myForm.submit();
}
function createActionControl(name, value){
    var myActionControl = document.createElement("input");
    myActionControl.setAttribute("type", "hidden");
    myActionControl.setAttribute("name", name);
    myActionControl.setAttribute("value", value);
    return myActionControl;
}

function createForm(action, method){
    var myForm = document.createElement("form");
    myForm.action = action;
    myForm.method = method;
    return myForm;
}


