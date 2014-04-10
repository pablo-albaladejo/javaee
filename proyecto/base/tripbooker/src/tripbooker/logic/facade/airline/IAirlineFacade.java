package tripbooker.logic.facade.airline;

import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;

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
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDeparture(String airportCode);
    List<IFlightBean> getAllFlightsByDestination(String airportCode);
    List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode);
    
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
}
