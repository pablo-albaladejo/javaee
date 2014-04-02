package tripbooker.dto.mapper;

import tripbooker.dto.bean.aircraft.IAircraftBean;
import tripbooker.dto.bean.airline.IAirlineBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;
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

public abstract class DTOMapper {
    private static DTOMapper instance;
    
    public static synchronized DTOMapper getInstance(){
        if(instance == null) instance = new DTOMapperImp();
        return instance;
    }
    
    //Country
    public abstract ICountryBean getCountryBean(ICountryDO countryDO);
    public abstract ICountryDO getCountryDO(ICountryBean countryBean);
    
    //City
    public abstract ICityBean getCityBean(ICityDO cityDO,  ICountryDO countryDO);
    public abstract ICityDO getCityDO(ICityBean cityBean, ICountryDO countryDO);
    
    //Airport
    public abstract IAirportDO getAirportDO(IAirportBean airportBean, ICityDO cityDO);
    public abstract IAirportBean getAirportBean(IAirportDO airportDO, ICityDO cityDO);
    
    //Flight
    public abstract IFlightBean getFlightBean(IFlightDO flightDO, 
                                                IAirlineDO airlineDO, 
                                                IRouteDO route, 
                                                IAirportDO departure, 
                                                IAirportDO destination,
                                                IAircraftDO aircraftDO);
    
    //Aircraft
    public abstract IAircraftBean getAircraftBean(IAircraftDO aircraftDO);
    public abstract IAircraftDO getAircraftDO(IAircraftBean aircraftBean);
    
    //Airline
    public abstract IAirlineBean getAirlineBean(IAirlineDO airlineDO, ICountryDO countryDO);
    public abstract IAirlineDO getAirlineDO(IAirlineBean airlineBean, ICountryDO countryDO);
    
    //Route
    public abstract IRouteBean getRouteBean(IRouteDO routeDO, IAirportDO departure, IAirportDO destination);
    public abstract IRouteDO getRouteDO(IRouteBean routeBean, IAirportDO departure, IAirportDO destination);
}

