package tripbooker.dto.domain.flight;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IFlightDO {
    public int getFlightID();
    public void setFlightID(int flightID);

    public String getCode();
    public void setCode(String code);

    public int getAirlineID();
    public void setAirlineID(int airlineID);

    public int getAircraftID();
    public void setAircraftID(int aircraftID);

    public int getRouteID();
    public void setRouteID(int routeID);

    public Date getDate();
    public void setDate(Date date);

    public float getEconomyFare();
    public void setEconomyFare(float economyFare);

    public float getBusinessFare();
    public void setBusinessFare(float businessFare);

    public float getOfferFare();
    public void setOfferFare(float offerFare);

    public int getBusinessSeats();
    public void setBusinessSeats(int businessSeats);
}
