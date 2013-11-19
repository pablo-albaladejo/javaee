package bookstore.presentation.controller.events;

/**
 * This class contais the coded actions for the Controller
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BusinessEvent {
    /**
     * Initialize Application Event
     */
    public static final int INIT_APPLICATION = 0;
    /**
     * Finalize Application Event
     */
    public static final int FINALIZE_APPLICATION = 1;
    
    /**
     * Get all books Event
     */
    public static final int GET_ALL_BOOKS = 1001;
    /**
     * Seach a book by an ISBN
     */
    public static final int GET_BOOK_ISBN = 1002;
    /**
     * Remove a book from the persistence by an ISBN
     */
    public static final int DELETE_BOOK_ISBN = 1003;
    /**
     * Add a book at the presistence
     */
    public static final int ADD_BOOK = 1004;
    /**
     * Modify an existing book from the persistence
     */
    public static final int MODIFY_BOOK = 1005;
}
