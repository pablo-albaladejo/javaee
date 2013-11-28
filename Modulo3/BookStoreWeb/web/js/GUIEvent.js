function guievent(){
/**
 * Searhc all books update Event
 */
this.SEARCH_ALL_BOOKS = 1001;
/**
 * Refresh all book event (main features)
 */
this.REFRESH_ALL_BOOKS = 1002;
/**
 * Refresh a book (complete features)
 */
this.REFRESH_BOOK = 1003;
/**
 * Update the GUI due to a Book removal
 */
this.BOOK_DELETED = 1004;
/**
 * Update the GUI due to a Book adition
 */
this.BOOK_ADDED = 1005;
/**
 * Generate a Error Deleting Book error
 */
this.ERROR_DELETING_BOOK = 1006;
/**
 * Generate a Error Adding Book error
 */
this.ERROR_ADDING_BOOK = 1007;
/**
 * Generate a Book Modified message
 */
this.BOOK_MODIFIED = 1008;
/**
 * Generate a Error Modifying Book error
 */
this.ERROR_MODIFYING_BOOK = 1009;
}
GUIEvent = new guievent();