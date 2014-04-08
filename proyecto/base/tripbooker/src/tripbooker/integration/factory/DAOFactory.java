package tripbooker.integration.factory;

import tripbooker.integration.aircraft.IAircraftDAO;
import tripbooker.integration.airline.IAirlineDAO;
import tripbooker.integration.airport.IAirportDAO;
import tripbooker.integration.booking.IBookingDAO;
import tripbooker.integration.city.ICityDAO;
import tripbooker.integration.country.ICountryDAO;
import tripbooker.integration.flight.IFlightDAO;
import tripbooker.integration.route.IRouteDAO;
import tripbooker.integration.ticket.ITicketDAO;
import tripbooker.integration.user.IUserDAO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class DAOFactory {
    private static DAOFactory instance;
    
    public static synchronized DAOFactory getInstance(){
        if(instance == null) instance = new DAOFactoryImp();
        return instance;
    }
    
    public abstract IAirlineDAO getAirlineDAO();
    public abstract IAircraftDAO getAircraftDAO();
    public abstract IAirportDAO getAirportDAO();
    public abstract IRouteDAO getRouteDAO();
    public abstract ICityDAO getCityDAO();
    public abstract ICountryDAO getCountryDAO();
    public abstract IFlightDAO getFlightDAO();
    public abstract IBookingDAO getBookingDAO();
    public abstract IUserDAO getUserDAO();
    public abstract ITicketDAO getTicketDAO();
}

