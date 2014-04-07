package tripbooker.dto.domain.factory;

import tripbooker.dto.domain.aircraft.AircraftDOImp;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.AirlineDOImp;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.AirportDOImp;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.booking.BookingDOImp;
import tripbooker.dto.domain.booking.IBookingDO;
import tripbooker.dto.domain.city.CityDOImp;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.country.CountryDOImp;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.domain.flight.FlightDOImp;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.domain.route.RouteDOImp;
import tripbooker.dto.domain.user.IUserDO;
import tripbooker.dto.domain.user.UserDOImp;


/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DOFactoryImp extends DOFactory{

    @Override
    public IAirlineDO getAirlineDO() {
        return new AirlineDOImp();
    }

    @Override
    public IAircraftDO getAircraftDO() {
        return new AircraftDOImp();
    }

    @Override
    public IAirportDO getAirportDO() {
       return new AirportDOImp();
    }

    @Override
    public IRouteDO getRouteDO() {
        return new RouteDOImp();
    }
    
    @Override
    public ICityDO getCityDO() {
        return new CityDOImp();
    }

    @Override
    public ICountryDO getCountryDO() {
        return new CountryDOImp();
    }
    
    @Override
    public IFlightDO getFlightDO() {
        return new FlightDOImp();
    }

    @Override
    public IBookingDO getBookingDO() {
        return new BookingDOImp();
    }

    @Override
    public IUserDO getUserDO() {
        return new UserDOImp();
    }
}
