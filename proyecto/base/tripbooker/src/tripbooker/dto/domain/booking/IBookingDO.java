package tripbooker.dto.domain.booking;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBookingDO {
    int getBookingID();
    void setBookingID(int bookingID);

    String getCode();
    void setCode(String code);
    
    int getUserID();
    void setUserID(int userID);

    int getFlightID();
    void setFlightID(int flightID);

    boolean isBusiness();
    void setBusiness(boolean business);
    
}
