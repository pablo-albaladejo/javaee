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
     
    String getDepartureCode();
    void setDepartureCode(String departureCode);
    
    String getDestinationCode();
    void setDestinationCode(String destinationCode);
    
    String getAircraftModel();
    void setAircraftModel(String aircraftModel);
    
    Date getDate();
    void setDate(Date date);

    float getEconomyFare();
    void setEconomyFare(float economyFare);

    float getBusinessFare();
    void setBusinessFare(float businessFare);

    float getOfferFare();
    void setOfferFare(float offerFare);

    int getBusinessSeats();
    void setBusinessSeats(int businessSeats);
}
