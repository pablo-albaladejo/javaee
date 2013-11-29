function update(action, data) {
    switch (action) {
        case GUIEvent.SEARCH_ALL_BOOKS:
            sendRequest(BusinessEvent.GET_ALL_BOOKS, data);
            break;
        case GUIEvent.REFRESH_ALL_BOOKS:
            refreshBooks(data);
            break;
        default:
            alert("Action not defined: " + action);
    }
}

