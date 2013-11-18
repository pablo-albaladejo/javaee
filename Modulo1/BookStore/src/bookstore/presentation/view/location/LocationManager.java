package bookstore.presentation.view.location;

/**
 *
 * <p>Pablo Albaladejo Mestre (pablo.albaladejo.mestre@gmail.com)</p>
 */
public abstract class LocationManager {
    
    /**
     *
     */
    public class Language {
        /**
         *
         */
        public static final int ENGLISH = 1001;
        /**
         *
         */
        public static final int SPANISH = 1002;
    };
    
    private static LocationManager instance = null;
    
    /**
     *
     * @return
     */
    public static LocationManager getInstance(){
        if(instance == null) instance = new LocationManagerImp();
        return instance;
    }
    
    /**
     *
     * @param MessageCode
     * @param language
     * @return
     */
    public abstract String getMessage(int MessageCode, int language);
}
