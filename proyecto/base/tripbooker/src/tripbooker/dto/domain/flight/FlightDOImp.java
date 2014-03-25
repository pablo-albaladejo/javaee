package tripbooker.dto.domain.flight;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightDOImp implements IFlightDO{
    private int flightID;
    private String code;
    private int airlineID;
    private int aircraftID;
    private int routeID;
    private Date date;
    private float economyFare;
    private float businessFare;
    private float offerFare;
    private int businessSeats;
    
    @Override
    public int getFlightID() {
        return flightID;
    }

    @Override
    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int getAirlineID() {
        return airlineID;
    }

    @Override
    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    @Override
    public int getAircraftID() {
        return aircraftID;
    }

    @Override
    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    @Override
    public int getRouteID() {
        return routeID;
    }

    @Override
    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public float getEconomyFare() {
        return economyFare;
    }

    @Override
    public void setEconomyFare(float economyFare) {
        this.economyFare = economyFare;
    }

    @Override
    public float getBusinessFare() {
        return businessFare;
    }

    @Override
    public void setBusinessFare(float businessFare) {
        this.businessFare = businessFare;
    }

    @Override
    public float getOfferFare() {
        return offerFare;
    }

    @Override
    public void setOfferFare(float offerFare) {
        this.offerFare = offerFare;
    }

    @Override
    public int getBusinessSeats() {
        return businessSeats;
    }

    @Override
    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }    
    
    @Override
    public String toString() {
        return "("
        + "flightID " + flightID
        + ", code: " + code
        + ", airlineID: " + airlineID 
        + ", aircraftID: " + aircraftID
        + ", routeID: " + routeID
        + ", date: " + date
        + ", economyFare: " + economyFare
        + ", businessFare: " + businessFare
        + ", offerFare: " + offerFare
        + ", businessSeats: " + businessSeats
        +")";
    }
}
