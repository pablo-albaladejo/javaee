package tripbooker.dto.bean.ticket;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ITicketBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getFlightCode();
    void setFlightCode(String flightCode);
    
    Date getFlightDate();
    void setFlightDate(Date flightDate);
    
    String getUserCode();
    void setUserCode(String userCode);
}
