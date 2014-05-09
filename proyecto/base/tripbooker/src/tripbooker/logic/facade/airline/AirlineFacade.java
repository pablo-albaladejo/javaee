package tripbooker.logic.facade.airline;

import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.bean.ticket.ITicketBean;
import tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirlineFacade implements IAirlineFacade{
    
//Flight
    //add-modify
    @Override
    public boolean persistFlight(IFlightBean flightBean) {
        return ServiceFactory.getInstance().getFlightService().persistFlight(flightBean);
    }
    
    //remove
    @Override
    public boolean removeFlight(IFlightBean flightBean) {
        return ServiceFactory.getInstance().getFlightService().removeFlight(flightBean);
    }
    
    //list
    @Override
    public List<IFlightBean> getAllFlights() {
         return ServiceFactory.getInstance().getFlightService().getAllFlights();
    }

    @Override
    public List<IFlightBean> getAllFlightsSeats() {
         return ServiceFactory.getInstance().getFlightService().getAllFlightsSeats();
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByAirline(String airlineCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByAirline(airlineCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDepartureAirport(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDepartureAirport(airportCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDestinationAirport(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDestinationAirport(airportCode);
    }

    @Override
    public List<IFlightBean> getAllFlightsByAirports(String depatureAirportCode, String destinationAirportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByAirports(depatureAirportCode,destinationAirportCode);
    }
    
//Route
    //add-modify
    @Override
    public boolean persistRoute(IRouteBean routeBean) {
        return ServiceFactory.getInstance().getRouteService().persistRoute(routeBean);
    }
    
    //remove
    @Override
    public boolean removeRoute(IRouteBean routeBean) {
        return ServiceFactory.getInstance().getRouteService().removeRoute(routeBean);
    }
    
    //list
    @Override
    public List<IRouteBean> getAllRoutes() {
        return ServiceFactory.getInstance().getRouteService().getAllRoutes();
    }

    @Override
    public List<IRouteBean> getAllRoutesByDeparture(String airportCode) {
        return ServiceFactory.getInstance().getRouteService().getAllRoutesByDeparture(airportCode);
    }

    @Override
    public List<IRouteBean> getAllRoutesByDestination(String airportCode) {
        return ServiceFactory.getInstance().getRouteService().getAllRoutesByDestination(airportCode);
    }

    @Override
    public IRouteBean getRoute(String departureCode, String destinationCode) {
        return ServiceFactory.getInstance().getRouteService().getRoute(departureCode, destinationCode);
    }

//Aircraft
    //add-modify
    @Override
    public boolean persistAircraft(IAircraftBean aircraftBean) {
        return ServiceFactory.getInstance().getAircraftService().persistAircraft(aircraftBean);
    }

    //remove
    @Override
    public boolean removeAircraft(IAircraftBean aircraftBean) {
        return ServiceFactory.getInstance().getAircraftService().removeAircraft(aircraftBean);
    }
    
    //lsit
    @Override
    public List<IAircraftBean> getAllAircrafts() {
        return ServiceFactory.getInstance().getAircraftService().getAllAircrafts();
    }     

    @Override
    public List<ITicketBean> getAllTickets() {
        return ServiceFactory.getInstance().getTicketService().getAllTickets();
    }

    @Override
    public List<ITicketBean> getAllTicketsByAirline(String airlineCode) {
        return ServiceFactory.getInstance().getTicketService().getAllTicketsByAirline(airlineCode);
    }
}
