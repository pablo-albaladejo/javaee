package tripbooker.dto.bean;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IFlightBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getAirline();
    void setAirline(String airline);
    
    String getDeparture();
    void setDeparture(String departure);
    
    String getDestination();
    void setDestination(String destination);
}
