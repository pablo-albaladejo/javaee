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

