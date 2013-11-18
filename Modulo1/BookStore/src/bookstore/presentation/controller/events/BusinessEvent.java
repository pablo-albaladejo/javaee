package bookstore.presentation.controller.events;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class BusinessEvent {
    /**
     *
     */
    public static final int INIT_APPLICATION = 0;
    /**
     *
     */
    public static final int FINALIZE_APPLICATION = 1;
    
    /**
     *
     */
    public static final int GET_ALL_BOOKS = 1001;
    /**
     *
     */
    public static final int GET_BOOK_ISBN = 1002;
    /**
     *
     */
    public static final int DELETE_BOOK_ISBN = 1003;
    /**
     *
     */
    public static final int ADD_BOOK = 1004;
    /**
     *
     */
    public static final int MODIFY_BOOK = 1005;
}
