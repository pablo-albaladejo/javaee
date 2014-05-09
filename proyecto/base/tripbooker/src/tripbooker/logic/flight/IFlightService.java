package tripbooker.logic.flight;

import java.util.Date;
import java.util.List;
import tripbooker.dto.bean.flight.IFlightBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IFlightService {
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsSeats();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDepartureAirport(String airportCode);
    List<IFlightBean> getAllFlightsByDestinationAirport(String airportCode);
    List<IFlightBean> getAllFlightsByAirports(String depatureAirpotCode, String destinationAirpotCode);
    boolean persistFlight(IFlightBean flightBean);
    boolean removeFlight(IFlightBean flightBean);
}
