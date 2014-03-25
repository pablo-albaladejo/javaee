package tripbooker.dto.factory;

import tripbooker.dto.bean.IFlightBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
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
    public abstract IFlightDO getFlightDO();
    public abstract IFlightBean getFlightBean();
}


