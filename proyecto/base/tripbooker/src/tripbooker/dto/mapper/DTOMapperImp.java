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
import tripbooker.dto.factory.DTOFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DTOMapperImp extends DTOMapper{
    
    //Country
    @Override
    public ICountryBean getCountryBean(ICountryDO countryDO) {
        ICountryBean countryBean = DTOFactory.getInstance().getCountryBean();
        
        countryBean.setCode(countryDO.getCode());
        countryBean.setName(countryDO.getName());
        
        return countryBean;
    }

    @Override
    public ICountryDO getCountryDO(ICountryBean countryBean) {
        ICountryDO countryDO = DTOFactory.getInstance().getCountryDO();

        countryDO.setCode(countryBean.getCode());
        countryDO.setName(countryBean.getName());
        
        return countryDO;
    }
    
    //City
    @Override
    public ICityBean getCityBean(ICityDO cityDO, ICountryDO countryDO) {
        ICityBean cityBean = DTOFactory.getInstance().getCityBean();
        
        cityBean.setCode(cityDO.getCode());
        cityBean.setName(cityDO.getName());
        cityBean.setCountryCode(countryDO.getCode());
        cityBean.setCountryName(countryDO.getName());
            
        return cityBean;
    }
    
    @Override
    public ICityDO getCityDO(ICityBean cityBean, ICountryDO countryDO) {
        ICityDO cityDO = DTOFactory.getInstance().getCityDO();
        
        cityDO.setCode(cityBean.getCode());
        cityDO.setName(cityBean.getName());
        cityDO.setCountryID(countryDO.getCountryID());
        
        return cityDO;
    }
    
    //Flight
    @Override
    public IFlightBean getFlightBean(IFlightDO flightDO, 
                                        IAirlineDO airlineDO, 
                                        IRouteDO routeDO, 
                                        IAirportDO departure, 
                                        IAirportDO destination,
                                        IAircraftDO aircraftDO){
        
        IFlightBean flightBean = DTOFactory.getInstance().getFlightBean();
       
            flightBean.setAirline(airlineDO.getName());
            flightBean.setCode(flightDO.getCode());
            flightBean.setDepartureName(departure.getName());
            flightBean.setDestinationName(destination.getName());
            flightBean.setDepartureCode(departure.getCode());
            flightBean.setDestinationCode(destination.getCode());
            flightBean.setDuration(routeDO.getDuration());
            flightBean.setDate(flightDO.getDate());
            flightBean.setSeats(aircraftDO.getSeats());
        
        return flightBean;
    }
    
    //Airport
    @Override
    public IAirportDO getAirportDO(IAirportBean airportBean, ICityDO cityDO) {
        IAirportDO airportDO = DTOFactory.getInstance().getAirportDO();
        
        airportDO.setCityID(cityDO.getCityID());
        airportDO.setName(airportBean.getName());
        airportDO.setCode(airportBean.getCode());
        
        return airportDO;
    }

    @Override
    public IAirportBean getAirportBean(IAirportDO airportDO, ICityDO cityDO) {
        IAirportBean airportBean = DTOFactory.getInstance().getAirportBean();
        
        airportBean.setCode(airportDO.getCode());
        airportBean.setName(airportDO.getName());
        airportBean.setCityCode(cityDO.getCode());
        airportBean.setCityName(cityDO.getName());
        
        return airportBean;
    }

    @Override
    public IAircraftBean getAircraftBean(IAircraftDO aircraftDO) {
        IAircraftBean aircraftBean = DTOFactory.getInstance().getAircraftBean();
        
        aircraftBean.setDate(aircraftDO.getDate());
        aircraftBean.setManufacter(aircraftDO.getManufacter());
        aircraftBean.setModel(aircraftDO.getModel());
        aircraftBean.setSeats(aircraftDO.getSeats());
        
        return aircraftBean;
    }

    @Override
    public IAircraftDO getAircraftDO(IAircraftBean aircraftBean) {
        IAircraftDO aircraftDO = DTOFactory.getInstance().getAircraftDO();
        
        aircraftDO.setDate(aircraftBean.getDate());
        aircraftDO.setManufacter(aircraftBean.getManufacter());
        aircraftDO.setModel(aircraftBean.getModel());
        aircraftDO.setSeats(aircraftBean.getSeats());
        
        return aircraftDO;
    }

    //Airline
    @Override
    public IAirlineBean getAirlineBean(IAirlineDO airlineDO, ICountryDO countryDO) {
        IAirlineBean airlineBean = DTOFactory.getInstance().getAirlineBean();
       
        airlineBean.setCode(airlineDO.getCode());
        airlineBean.setCountryCode(countryDO.getCode());
        airlineBean.setName(airlineDO.getName());
        
        return airlineBean;
    }

    @Override
    public IAirlineDO getAirlineDO(IAirlineBean airlineBean, ICountryDO countryDO) {
        IAirlineDO airlineDO = DTOFactory.getInstance().getAirlineDO();
        
        airlineDO.setCode(airlineBean.getCode());
        airlineDO.setCountryID(countryDO.getCountryID());
        airlineDO.setName(airlineBean.getName());
        
        return airlineDO;
    }

    //Route
    @Override
    public IRouteBean getRouteBean(IRouteDO routeDO, IAirportDO departure, IAirportDO destination) {
        IRouteBean routeBean = DTOFactory.getInstance().getRouteBean();

        routeBean.setCode(routeDO.getCode());
        routeBean.setDepartureCode(departure.getCode());
        routeBean.setDestinationCode(destination.getCode());
        routeBean.setDuration(routeDO.getDuration());
        
        return routeBean;
    }

    @Override
    public IRouteDO getRouteDO(IRouteBean routeBean, IAirportDO departure, IAirportDO destination) {
        IRouteDO routeDO = DTOFactory.getInstance().getRouteDO();
        
        routeDO.setCode(routeBean.getCode());
        routeDO.setDepartureID(departure.getAirportID());
        routeDO.setDestinationID(destination.getAirportID());
        routeDO.setDuration(routeBean.getDuration());
        
        return routeDO;
    }
}
