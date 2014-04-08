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
import tripbooker.dto.bean.user.IUserBean;
import tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BusinessFacade implements IBusinessFacade{

    //Aircraft
    @Override
    public List<IAircraftBean> getAllAircrafts() {
        return ServiceFactory.getInstance().getAircraftService().getAllAircrafts();
    }

    @Override
    public boolean persistAircraft(IAircraftBean aircraftBean) {
        return ServiceFactory.getInstance().getAircraftService().persistAircraft(aircraftBean);
    }

    @Override
    public boolean removeAircraft(IAircraftBean aircraftBean) {
        return ServiceFactory.getInstance().getAircraftService().removeAircraft(aircraftBean);
    }
        
    //Airline
    @Override
    public List<IAirlineBean> getAllAirlines() {
        return ServiceFactory.getInstance().getAirlineService().getAllAirlines();
    }

    @Override
    public boolean persistAirline(IAirlineBean airlineBean) {
        return ServiceFactory.getInstance().getAirlineService().persistAirline(airlineBean);
    }

    @Override
    public boolean removeAirline(IAirlineBean airlineBean) {
        return ServiceFactory.getInstance().getAirlineService().removeAirline(airlineBean);
    }
    
    
    @Override
    public List<IAirportBean> getAllAirports() {
        return ServiceFactory.getInstance().getAirportService().getAllAirports();
    }

    @Override
    public List<IAirportBean> getAirportsByCity(String code) {
        return ServiceFactory.getInstance().getAirportService().getAirportsByCity(code);
    }
    
    @Override
    public boolean persistAirport(IAirportBean airportBean) {
        return ServiceFactory.getInstance().getAirportService().persistAirport(airportBean);
    }

    @Override
    public boolean removeAirport(IAirportBean airportBean) {
        return ServiceFactory.getInstance().getAirportService().removeAirport(airportBean);
    }
    
    
    @Override
    public List<ICityBean> getAllCities() {
        return ServiceFactory.getInstance().getCityService().getAllCities();
    }
    
    @Override
    public boolean persistCity(ICityBean cityBean) {
        return ServiceFactory.getInstance().getCityService().persistCity(cityBean);
    }

    @Override
    public boolean removeCity(ICityBean cityBean) {
        return ServiceFactory.getInstance().getCityService().removeCity(cityBean);
    }
    
        @Override
    public List<ICountryBean> getAllCountries() {
        return ServiceFactory.getInstance().getCountryService().getAllCountries();
    }

    @Override
    public boolean persistCountry(ICountryBean countryBean) {
        return ServiceFactory.getInstance().getCountryService().persistCountry(countryBean);
    }

    @Override
    public boolean removeCountry(ICountryBean countryBean) {
        return ServiceFactory.getInstance().getCountryService().removeCountry(countryBean);
    }
    
    //Flight
    @Override
    public List<IFlightBean> getAllFlights() {
         return ServiceFactory.getInstance().getFlightService().getAllFlights();
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByAirline(String airlineCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByAirline(airlineCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDeparture(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDeparture(airportCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDestination(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDestination(airportCode);
    }

    @Override
    public List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByRoute(depatureCode,destinationCode);
    }

    @Override
    public boolean persistFlight(IFlightBean flightBean) {
        return ServiceFactory.getInstance().getFlightService().persistFlight(flightBean);
    }

    @Override
    public boolean removeFlight(IFlightBean flightBean) {
        return ServiceFactory.getInstance().getFlightService().removeFlight(flightBean);
    }
    
    //Route    
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

    @Override
    public boolean removeRoute(IRouteBean routeBean) {
        return ServiceFactory.getInstance().getRouteService().removeRoute(routeBean);
    }

    @Override
    public boolean persistRoute(IRouteBean routeBean) {
        return ServiceFactory.getInstance().getRouteService().persistRoute(routeBean);
    }

    //User
    @Override
    public List<IUserBean> getAllUsers() {
        return ServiceFactory.getInstance().getUserService().getAllUsers();
    }

    @Override
    public IUserBean getUserByCode(String code) {
        return ServiceFactory.getInstance().getUserService().getUserByCode(code);
    }

    @Override
    public boolean removeUser(IUserBean userBean) {
        return ServiceFactory.getInstance().getUserService().removeUser(userBean);
    }

    @Override
    public boolean persistUser(IUserBean userBean) {
        return ServiceFactory.getInstance().getUserService().persistUser(userBean);
    }    
    
    //Booking
    @Override
    public List<IBookingBean> getAllBookings() {
        return ServiceFactory.getInstance().getBookingService().getAllBookings();
    }

    @Override
    public IBookingBean getBookingByCode(String code) {
        return ServiceFactory.getInstance().getBookingService().getBookingByCode(code);
    }

    @Override
    public boolean persistBooking(IBookingBean bookingBean) {
        return ServiceFactory.getInstance().getBookingService().persistBooking(bookingBean);
    }

    @Override
    public boolean removeBooking(IBookingBean bookingBean) {
        return ServiceFactory.getInstance().getBookingService().removeBooking(bookingBean);
    }
}
