package tripbooker.dto.bean.booking;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBookingBean extends Serializable{
    String getBookingCode();
    void setBookingCode(String bookingCode);

    String getUserCode();
    void setUserCode(String userCode);

    String getFlightCode();
    void setFlightCode(String flightCode);

    boolean isBusiness();
    void setBusiness(boolean business);
    
    Date getFlightDate();
    void setFlightDate(Date flightDate);
}
