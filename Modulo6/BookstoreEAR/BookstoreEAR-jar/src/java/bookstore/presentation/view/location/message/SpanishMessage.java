package bookstore.presentation.view.location.message;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public class SpanishMessage {
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
                message = "Datos no válidos";
                break;
            case MessageCode.BOOKS_LOADED:
                message = "Libro cargado";
                break;
            case MessageCode.BOOK_DELETED:
                message = "Libro borrado";
                break;
            case MessageCode.BOOK_ADDED:
                message = "Libro añadido";
                break;
            case MessageCode.ERROR_DELETING_BOOK:
                message = "Error borrando libro";
                break;
            case MessageCode.ERROR_ADDING_BOOK:
                message = "Error añadiendo libro";
                break;
            case MessageCode.ERROR_MODIFYING_BOOK:
                message = "Error modificando libro";
                break;
            case MessageCode.BOOK_MODIFIED:
                message = "Libro modificado";
                break;
            default:
                message = "Mensaje no definido: "+code;
                break;
        }
        
        return message;
    }
}
