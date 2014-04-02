package tripbooker.dto.domain.route;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IRouteDO {
    int getRouteID();
    void setRouteID(int routeID);

    String getCode();
    void setCode(String code);
    
    int getDepartureID();
    void setDepartureID(int departureID);

    int getDestinationID();
    void setDestinationID(int destinationID);

    int getDuration();
    void setDuration(int duration);
}
