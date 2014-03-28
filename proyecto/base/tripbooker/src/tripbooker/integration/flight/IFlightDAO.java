package tripbooker.integration.flight;

import java.util.List;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IFlightDAO {
    List<IFlightDO> getAllFlights()throws TransactionException;
    IFlightDO getFlightByID(int id)throws TransactionException;
    List<IFlightDO> getFlightsByAirline(int airlineID)throws TransactionException;
    List<IFlightDO> getFlightsByRoute(int routeID)throws TransactionException;
    boolean removeFlight(int id) throws TransactionException;
    boolean insertFlight(IFlightDO flight) throws TransactionException;
}