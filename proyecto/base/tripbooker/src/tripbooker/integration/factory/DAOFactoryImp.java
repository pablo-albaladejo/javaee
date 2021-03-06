package tripbooker.integration.factory;

import tripbooker.integration.aircraft.AircraftDAOImp;
import tripbooker.integration.aircraft.IAircraftDAO;
import tripbooker.integration.airline.AirlineDAOImp;
import tripbooker.integration.airline.IAirlineDAO;
import tripbooker.integration.airport.AirportDAOImp;
import tripbooker.integration.airport.IAirportDAO;
import tripbooker.integration.booking.BookingDAOImp;
import tripbooker.integration.booking.IBookingDAO;
import tripbooker.integration.city.CityDAOImp;
import tripbooker.integration.city.ICityDAO;
import tripbooker.integration.country.CountryDAOImp;
import tripbooker.integration.country.ICountryDAO;
import tripbooker.integration.flight.FlightDAOImp;
import tripbooker.integration.flight.IFlightDAO;
import tripbooker.integration.route.IRouteDAO;
import tripbooker.integration.route.RouteDAOImp;
import tripbooker.integration.ticket.ITicketDAO;
import tripbooker.integration.ticket.TicketDAOImp;
import tripbooker.integration.user.IUserDAO;
import tripbooker.integration.user.UserDAOImp;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DAOFactoryImp extends DAOFactory{

    @Override
    public IAirlineDAO getAirlineDAO() {
        return new AirlineDAOImp();
    }

    @Override
    public IAircraftDAO getAircraftDAO() {
        return new AircraftDAOImp();
    }

    @Override
    public IAirportDAO getAirportDAO() {
        return new AirportDAOImp();
    }

    @Override
    public IRouteDAO getRouteDAO() {
        return new RouteDAOImp();
    }
    
    @Override
    public ICityDAO getCityDAO() {
        return new CityDAOImp();
    }

    @Override
    public ICountryDAO getCountryDAO() {
        return new CountryDAOImp();
    }
    
    @Override
    public IFlightDAO getFlightDAO() {
        return new FlightDAOImp();
    }

    @Override
    public IBookingDAO getBookingDAO() {
        return new BookingDAOImp();
    }

    @Override
    public IUserDAO getUserDAO() {
        return new UserDAOImp();
    }

    @Override
    public ITicketDAO getTicketDAO() {
        return new TicketDAOImp();
    }
}
