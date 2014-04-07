package tripbooker.logic.factory;

import tripbooker.logic.aircraft.AircraftServiceImp;
import tripbooker.logic.aircraft.IAircraftService;
import tripbooker.logic.airline.AirlineServiceImp;
import tripbooker.logic.airline.IAirlineService;
import tripbooker.logic.airport.AirportServiceImp;
import tripbooker.logic.airport.IAirportService;
import tripbooker.logic.booking.BookingServiceImp;
import tripbooker.logic.booking.IBookingService;
import tripbooker.logic.city.CityServiceImp;
import tripbooker.logic.city.ICityService;
import tripbooker.logic.country.CountryServiceImp;
import tripbooker.logic.country.ICountryService;
import tripbooker.logic.facade.airline.AirlineBusinessFacade;
import tripbooker.logic.facade.airline.IAirlineBusinessFacade;
import tripbooker.logic.facade.business.BusinessFacade;
import tripbooker.logic.facade.business.IBusinessFacade;
import tripbooker.logic.facade.system.ISystemBusinessFacade;
import tripbooker.logic.facade.system.SystemBusinessFacade;
import tripbooker.logic.facade.user.IUserBusinessFacade;
import tripbooker.logic.facade.user.UserBusinessFacade;
import tripbooker.logic.flight.FlightServiceImp;
import tripbooker.logic.flight.IFlightService;
import tripbooker.logic.route.IRouteService;
import tripbooker.logic.route.RouteServiceImp;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ServiceFactoryImp extends ServiceFactory{

    //Aircraft
    @Override
    public IAircraftService getAircraftService() {
        return new AircraftServiceImp();
    }
    
    //Airline
    @Override
    public IAirlineService getAirlineService() {
        return new AirlineServiceImp();
    }
    
    @Override
    public IAirportService getAirportService() {
        return new AirportServiceImp();
    }
    
    @Override
    public IFlightService getFlightService() {
        return new FlightServiceImp();
    }

    @Override
    public ICityService getCityService() {
        return new CityServiceImp();
    }
    
    @Override
    public ICountryService getCountryService() {
        return new CountryServiceImp();
    }
    
    @Override
    public ISystemBusinessFacade getSystemBusinessFacade() {
        return new SystemBusinessFacade();
    }

    @Override
    public IAirlineBusinessFacade getAirlineBusinessFacade() {
        return new AirlineBusinessFacade();
    }

    @Override
    public IUserBusinessFacade getUserBusinessFacade() {
        return new UserBusinessFacade();
    }
    
    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }
    
    //Route
    @Override
    public IRouteService getRouteService() {
        return new RouteServiceImp();
    }
    
    //Booking
    @Override
    public IBookingService getBookingService() {
        return new BookingServiceImp();
    }
    
}
