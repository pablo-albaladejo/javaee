package tripbooker.dto.bean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightBean implements IFlightBean{
    private static final long serialVersionUID = 1L;
    
    private String code;
    private String airline;
    private String departure;
    private String destination;
    
    
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
    public String getDeparture() {
        return departure;
    }

    @Override
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "FlightBean{" + "code=" + code + ", airline=" + airline + ", departure=" + departure + ", destination=" + destination + '}';
    }
}
