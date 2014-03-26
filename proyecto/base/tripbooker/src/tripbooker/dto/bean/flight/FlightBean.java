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
    private String departureName;
    private String departureCode;
    private String destinationName;
    private String destinationCode;
    private Date date;
    private int duration;
    private int seats;
 
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
    public String getDepartureName() {
        return departureName;
    }

    @Override
    public void setDepartureName(String departureName) {
        this.departureName = departureName;
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
    public String getDestinationName() {
        return destinationName;
    }

    @Override
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
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
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "FlightBean{" + "code=" + code + ", airline=" + airline + ", departureName=" + departureName + ", departureCode=" + departureCode + ", destinationName=" + destinationName + ", destinationCode=" + destinationCode + ", date=" + date + ", duration=" + duration + ", seats=" + seats + '}';
    }
}
