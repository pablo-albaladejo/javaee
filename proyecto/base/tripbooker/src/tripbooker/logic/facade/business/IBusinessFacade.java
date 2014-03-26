package tripbooker.logic.facade.business;

import java.util.List;
import tripbooker.dto.bean.IFlightBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBusinessFacade {
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDeparture(String airportCode);
    List<IFlightBean> getAllFlightsByDestination(String airportCode);
    List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode);
}
