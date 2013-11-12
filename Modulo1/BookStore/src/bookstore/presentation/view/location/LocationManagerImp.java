package bookstore.presentation.view.location;

import bookstore.presentation.view.location.message.EnglishMessage;
import bookstore.presentation.view.location.message.SpanishMessage;

/**
 *
 * Pablo Albaladejo Mestre(pablo.albaladejo.mestre@gmail.com)
 */
public class LocationManagerImp extends LocationManager{

    /**
     *
     * @param MessageCode
     * @param language
     * @return
     */
    @Override
    public String getMessage(int MessageCode, int language) {
        String message;
        
        switch(language){
            case Language.ENGLISH:
                message = EnglishMessage.getMessage(MessageCode);
                break;
            case Language.SPANISH:
                message = SpanishMessage.getMessage(MessageCode);
                break;
            default:
                message = "No Language Available";
                break;
        }
        
        return message;
    }
    
}
