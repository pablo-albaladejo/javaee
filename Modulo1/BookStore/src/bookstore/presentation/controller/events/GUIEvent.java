package bookstore.presentation.controller.events;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class GUIEvent {
    /**
     * Searhc all books update Event
     */
    public static final int SEARCH_ALL_BOOKS = 1001;
    /**
     * Refresh all book event (main features)
     */
    public static final int REFRESH_ALL_BOOKS = 1002;
    /**
     * Refresh a book (complete features)
     */
    public static final int REFRESH_BOOK = 1003;
    /**
     * Update the GUI due to a Book removal
     */
    public static final int BOOK_DELETED = 1004;
    /**
     * Update the GUI due to a Book adition
     */
    public static final int BOOK_ADDED = 1005;
    /**
     * Generate a Error Deleting Book error
     */
    public static final int ERROR_DELETING_BOOK = 1006;
    /**
     * Generate a Error Adding Book error
     */
    public static final int ERROR_ADDING_BOOK = 1007;
    /**
     * Generate a Book Modified message
     */
    public static final int BOOK_MODIFIED = 1008;
    /**
     * Generate a Error Modifying Book error
     */
    public static final int ERROR_MODIFYING_BOOK = 1009;
    
}
