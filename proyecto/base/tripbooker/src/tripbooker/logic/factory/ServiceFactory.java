package tripbooker.logic.factory;

import tripbooker.logic.aircraft.IAircraftService;
import tripbooker.logic.airline.IAirlineService;
import tripbooker.logic.airport.IAirportService;
import tripbooker.logic.booking.IBookingService;
import tripbooker.logic.city.ICityService;
import tripbooker.logic.country.ICountryService;
import tripbooker.logic.facade.airline.IAirlineBusinessFacade;
import tripbooker.logic.facade.business.IBusinessFacade;
import tripbooker.logic.facade.system.ISystemBusinessFacade;
import tripbooker.logic.facade.user.IUserBusinessFacade;
import tripbooker.logic.flight.IFlightService;
import tripbooker.logic.route.IRouteService;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class ServiceFactory {
    private static ServiceFactory instance;
    
    public static synchronized ServiceFactory getInstance(){
        if(instance == null) instance = new ServiceFactoryImp();
        return instance;
    }
    
    //Profile Facades
    public abstract IBusinessFacade getBusinessFacade();
    public abstract ISystemBusinessFacade getSystemBusinessFacade();
    public abstract IAirlineBusinessFacade getAirlineBusinessFacade();
    public abstract IUserBusinessFacade getUserBusinessFacade();
    
    //Application Services
    public abstract IAircraftService getAircraftService();
    public abstract IAirlineService getAirlineService();
    public abstract IAirportService getAirportService();
    public abstract IFlightService getFlightService();
    public abstract ICountryService getCountryService();
    public abstract ICityService getCityService();
    public abstract IRouteService getRouteService();
    public abstract IBookingService getBookingService();
    
}
