package tripbooker.dto.domain.factory;

import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.booking.IBookingDO;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.domain.user.IUserDO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class DOFactory {
    private static DOFactory instance;
    
    public static synchronized DOFactory getInstance(){
        if(instance == null) instance = new DOFactoryImp();
        return instance;
    }
    
    public abstract IFlightDO getFlightDO();
    public abstract IAirportDO getAirportDO();
    public abstract ICityDO getCityDO();
    public abstract ICountryDO getCountryDO();
    public abstract IAircraftDO getAircraftDO();
    public abstract IAirlineDO getAirlineDO();
    public abstract IRouteDO getRouteDO();    
    public abstract IBookingDO getBookingDO();
    public abstract IUserDO getUserDO();
   
}


