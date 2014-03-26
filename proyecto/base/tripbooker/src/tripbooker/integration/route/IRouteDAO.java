package tripbooker.integration.route;

import java.util.List;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IRouteDAO {
    List<IRouteDO> getAllRoutes()throws TransactionException;
    IRouteDO getRouteByID(int id)throws TransactionException;
    List<IRouteDO> getAllRoutesByDeparture(int airportID)throws TransactionException;
    List<IRouteDO> getAllRoutesByDestination(int airportID)throws TransactionException;
    List<IRouteDO> getAllRoutesByRoute(int departureID, int destinationID)throws TransactionException;
    boolean removeRoute(int id) throws TransactionException;
    boolean insertRoute(IRouteDO route) throws TransactionException;
}
