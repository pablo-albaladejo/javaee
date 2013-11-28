function businessevent(){
/**
 * Get all books Event
 */
this.GET_ALL_BOOKS = 1001;
/**
 * Seach a book by an ISBN
 */
this.GET_BOOK_ISBN = 1002;
/**
 * Remove a book from the persistence by an ISBN
 */
this.DELETE_BOOK_ISBN = 1003;
/**
 * Add a book at the presistence
 */
this.ADD_BOOK = 1004;
/**
 * Modify an existing book from the persistence
 */
this.MODIFY_BOOK = 1005;
}

BusinessEvent = new businessevent();
