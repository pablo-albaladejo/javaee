package tripbooker.presentation.controller.event;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface GUIEvent {
   
    //ERROR
    public static final int ERROR_NOT_ALL_FILLED  = 0000;
    
    //LOAD
    public static final int LOAD_DEPARTURE_CITY  = 1001;
    public static final int LOAD_DEPARTURE_AIRPORT  = 1002;
    public static final int LOAD_DESTINATION_CITY  = 1003;
    public static final int LOAD_DESTINATION_AIRPORT  = 1004;
    public static final int LOAD_COUNTRIES  = 1005;
    
    //REFRESH
    public static final int REFRESH_COUNTRIES  = 2001;
    public static final int REFRESH_FLIGHTS  = 2002;
}
