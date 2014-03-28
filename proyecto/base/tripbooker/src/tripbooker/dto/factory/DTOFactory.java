package tripbooker.dto.factory;

import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class DTOFactory {
    private static DTOFactory instance;
    
    public static synchronized DTOFactory getInstance(){
        if(instance == null) instance = new DTOFactoryImp();
        return instance;
    }
    
    public abstract IAirlineDO getAirlineDO();
    public abstract IAircraftDO getAircraftDO();
    public abstract IAirportDO getAirportDO();
    public abstract IRouteDO getRouteDO();
    public abstract ICityDO getCityDO();
    public abstract ICountryDO getCountryDO();
    public abstract IFlightDO getFlightDO();
    
    public abstract IFlightBean getFlightBean();
    public abstract IAirportBean getAirportBean();
    public abstract ICityBean getCityBean();
    public abstract ICountryBean getCountryBean();
}


