package tripbooker.presentation.controller.event;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface BusinessEvent {
    //APP
    public static final int APP_START  = 0;
    
    //USER
    public static final int USER_LOAD_COUNTRIES  = 1001;
    public static final int USER_SEARCH_FLIGHTS  = 1101;
}
