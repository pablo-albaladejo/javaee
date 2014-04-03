package tripbooker.logic.route;

import java.util.List;
import tripbooker.dto.bean.route.IRouteBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IRouteService {
    List<IRouteBean> getAllRoutes();
    List<IRouteBean> getAllRoutesByDeparture(String airportCode);
    List<IRouteBean> getAllRoutesByDestination(String airportCode);
    IRouteBean getRoute(String departureCode, String destinationCode);
    boolean removeRoute(IRouteBean routeBean);
    boolean persistRoute(IRouteBean routeBean);
}
