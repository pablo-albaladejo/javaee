package tripbooker.dto.bean.flight;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IFlightBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getAirline();
    void setAirline(String airline);
    
    String getDepartureName();
    void setDepartureName(String departureName);
    
    String getDepartureCode();
    void setDepartureCode(String departureCode);
    
    String getDestinationName();
    void setDestinationName(String destinationName);
    
    String getDestinationCode();
    void setDestinationCode(String destinationCode);
    
    Date getDate();
    void setDate(Date date);

    int getDuration();
    void setDuration(int duration);
    
    int getSeats();
    void setSeats(int seats);
}
