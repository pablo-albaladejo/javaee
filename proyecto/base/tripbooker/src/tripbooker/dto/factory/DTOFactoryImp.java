package tripbooker.dto.factory;

import tripbooker.dto.bean.airport.AirportBean;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.CityBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.CountryBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.FlightBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.domain.aircraft.AircraftDOImp;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.AirlineDOImp;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.AirportDOImp;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.city.CityDOImp;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.country.CountryDOImp;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.domain.flight.FlightDOImp;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.domain.route.RouteDOImp;


/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DTOFactoryImp extends DTOFactory{

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
    public IFlightBean getFlightBean() {
        return new FlightBean();
    }

    @Override
    public IAirportBean getAirportBean() {
        return new AirportBean();
    }

    @Override
    public ICityBean getCityBean() {
        return new CityBean();
    }

    @Override
    public ICountryBean getCountryBean() {
        return new CountryBean();
    }
}
