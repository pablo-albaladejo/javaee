package tripbooker.dto.domain.route;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class RouteDOImp implements IRouteDO{
    
    private int routeID;
    private int departureID;
    private int destinationID;
    private int duration;

    @Override
    public int getRouteID() {
        return routeID;
    }

    @Override
    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    @Override
    public int getDepartureID() {
        return departureID;
    }

    @Override
    public void setDepartureID(int departureID) {
        this.departureID = departureID;
    }

    @Override
    public int getDestinationID() {
        return destinationID;
    }

    @Override
    public void setDestinationID(int destinationID) {
        this.destinationID = destinationID;
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
        return "("
        + "routeID " + routeID
        + ", departureID: " + departureID
        + ", destinationID: " + destinationID 
        + ", duration: " + duration
        +")";
    }
    
}
