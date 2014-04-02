package tripbooker.dto.bean.route;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IRouteBean extends Serializable{
    
    String getCode();
    void setCode(String code);
    
    String getDepartureCode();
    void setDepartureCode(String departureCode);

    String getDestinationCode();
    void setDestinationCode(String destinationCode);

    int getDuration();
    void setDuration(int duration);
}
