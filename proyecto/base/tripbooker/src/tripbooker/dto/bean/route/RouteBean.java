package tripbooker.dto.bean.route;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class RouteBean implements IRouteBean{
    private String departureCode;
    private String destinationCode;
    private int duration;
   
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
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "RouteBean{" + "departureCode=" + departureCode + ", destinationCode=" + destinationCode + ", duration=" + duration + '}';
    }

    
}
