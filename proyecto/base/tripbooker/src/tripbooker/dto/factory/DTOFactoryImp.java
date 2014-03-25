package tripbooker.dto.factory;

import tripbooker.dto.bean.FlightBean;
import tripbooker.dto.bean.IFlightBean;
import tripbooker.dto.domain.aircraft.AircraftDOImp;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.AirlineDOImp;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.AirportDOImp;
import tripbooker.dto.domain.airport.IAirportDO;
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
    public IFlightDO getFlightDO() {
        return new FlightDOImp();
    }

    @Override
    public IFlightBean getFlightBean() {
        return new FlightBean();
    }
}
