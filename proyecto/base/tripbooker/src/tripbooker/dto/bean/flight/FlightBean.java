package tripbooker.dto.bean.flight;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightBean implements IFlightBean{
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String airline;
    private String departureCode;
    private String destinationCode;
    private String aircraftModel;
    private Date date;
    private float economyFare;
    private float businessFare;
    private float offerFare;
    private int businessSeats;
    
 
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getAirline() {
        return airline;
    }

    @Override
    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public String getDepartureCode() {
        return departureCode;
    }

    @Override
    public void setDepartureCode(String departureCode) {
        this.departureCode = departureCode;
    }
    
    @Override
    public String getDestinationCode() {
        return destinationCode;
    }

    @Override
    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    @Override
    public String getAircraftModel() {
        return aircraftModel;
    }

    @Override
    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
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
        return "FlightBean{" + "code=" + code + ", airline=" + airline + ", departureCode=" + departureCode + ", destinationCode=" + destinationCode + ", aircraftModel=" + aircraftModel + ", date=" + date + ", economyFare=" + economyFare + ", businessFare=" + businessFare + ", offerFare=" + offerFare + ", businessSeats=" + businessSeats + '}';
    }

}
