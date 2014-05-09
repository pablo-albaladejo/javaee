package tripbooker.logic.facade.airline;

import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.bean.ticket.ITicketBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirlineFacade {
    
//Flight
    //add-modify
    boolean persistFlight(IFlightBean flightBean);
    //remove
    boolean removeFlight(IFlightBean flightBean);    
    //list
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsSeats();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDepartureAirport(String airportCode);
    List<IFlightBean> getAllFlightsByDestinationAirport(String airportCode);
    List<IFlightBean> getAllFlightsByAirports(String depatureAirportCode, String destinationAirportCode);
    
//Route
    //add-modify
    boolean persistRoute(IRouteBean routeBean);
    //remove
    boolean removeRoute(IRouteBean routeBean);           
    //list
    List<IRouteBean> getAllRoutes();
    List<IRouteBean> getAllRoutesByDeparture(String airportCode);
    List<IRouteBean> getAllRoutesByDestination(String airportCode);
    IRouteBean getRoute(String departureCode, String destinationCode);
    
//Aircraft
    //add-modify
    boolean persistAircraft(IAircraftBean aircraftBean);
    //remove
    boolean removeAircraft(IAircraftBean aircraftBean);
    //list
    List<IAircraftBean> getAllAircrafts();

//Ticket
    List<ITicketBean> getAllTickets();
    List<ITicketBean> getAllTicketsByAirline(String airlineCode);
}
