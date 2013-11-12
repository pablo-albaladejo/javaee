package bookstore.presentation.view.location.message;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
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
                message = "Ok";
                break;
            case MessageCode.INVALID_DATA:
                message = "Datos no válidos";
                break;
            case MessageCode.BOOKS_LOADED:
                message = "Libros Cargados";
                break;
            default:
                message = "Cadena no definida: "+code;
                break;
        }
        
        return message;
    }
}
