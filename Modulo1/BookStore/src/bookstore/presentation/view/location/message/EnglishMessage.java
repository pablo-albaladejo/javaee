package bookstore.presentation.view.location.message;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class EnglishMessage {

    /**
     *
     * @param code
     * @return
     */
    public static String getMessage(int code) {
        String message;
        
        switch(code){
            case MessageCode.ERROR:
                message = "Error";
                break;
            case MessageCode.OK:
                message = "OK";
                break;
            case MessageCode.INVALID_DATA:
                message = "Invalid data";
                break;
            case MessageCode.BOOKS_LOADED:
                message = "Books loaded";
                break;
            case MessageCode.BOOK_DELETED:
                message = "Book deleted";
                break;
            case MessageCode.BOOK_ADDED:
                message = "Book added";
                break;
            case MessageCode.ERROR_DELETING_BOOK:
                message = "Error deleting book";
                break;
            case MessageCode.ERROR_ADDING_BOOK:
                message = "Error adding book";
                break;
            case MessageCode.ERROR_MODIFYING_BOOK:
                message = "Error modifying book";
                break;
            case MessageCode.BOOK_MODIFIED:
                message = "Book modified";
                break;
            default:
                message = "String not defined: "+code;
                break;
        }
        
        return message;
    }
    
}
