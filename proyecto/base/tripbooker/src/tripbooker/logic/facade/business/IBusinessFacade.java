package tripbooker.logic.facade.business;

import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.booking.IBookingBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
import tripbooker.dto.bean.ticket.ITicketBean;
import tripbooker.dto.bean.user.IUserBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBusinessFacade {
    //Aircraft
    List<IAircraftBean> getAllAircrafts();
    boolean persistAircraft(IAircraftBean aircraftBean);
    boolean removeAircraft(IAircraftBean aircraftBean);

    //Airline
    List<IAirlineBean> getAllAirlines();
    boolean persistAirline(IAirlineBean airlineBean);
    boolean removeAirline(IAirlineBean airlineBean);
    
    //Airport
    List<IAirportBean> getAllAirports();
    List<IAirportBean> getAllAirportsByCity(String code);
    boolean persistAirport(IAirportBean airportBean);
    boolean removeAirport(IAirportBean airportBean);
    
    //City
    List<ICityBean> getAllCities();
    List<ICityBean> getAllCitiesByCountry(String code);
    ICityBean getCityByName(String name);
    boolean persistCity(ICityBean cityBean);
    boolean removeCity(ICityBean cityBean);
    
    //Country
    List<ICountryBean> getAllCountries();
    ICountryBean getCountryByName(String name);
    boolean persistCountry(ICountryBean countryBean);
    boolean removeCountry(ICountryBean countryBean);
    
    //Flight
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDeparture(String airportCode);
    List<IFlightBean> getAllFlightsByDestination(String airportCode);
    List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode);
    boolean persistFlight(IFlightBean flightBean);
    boolean removeFlight(IFlightBean flightBean);
    
    //Route
    List<IRouteBean> getAllRoutes();
    List<IRouteBean> getAllRoutesByDeparture(String airportCode);
    List<IRouteBean> getAllRoutesByDestination(String airportCode);
    IRouteBean getRoute(String departureCode, String destinationCode);
    boolean removeRoute(IRouteBean routeBean);
    boolean persistRoute(IRouteBean routeBean);
    
    //User
    List<IUserBean> getAllUsers();
    IUserBean getUserByCode(String code);
    boolean removeUser(IUserBean userBean);
    boolean persistUser(IUserBean userBean);
    
    //Booking
    List<IBookingBean> getAllBookings();
    IBookingBean getBookingByCode(String code);
    boolean persistBooking(IBookingBean bookingBean);
    boolean removeBooking(IBookingBean bookingBean);
    
    //Ticket
    List<ITicketBean> getAllTickets();
    ITicketBean getTicketByCode(String code);
    boolean persistTicket(ITicketBean ticketBean);
    boolean removeTicket(ITicketBean ticketBean);
}
