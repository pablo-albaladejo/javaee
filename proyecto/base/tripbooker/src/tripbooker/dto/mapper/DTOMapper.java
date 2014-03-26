package tripbooker.dto.mapper;

import java.util.List;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
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
    
    public abstract IFlightBean getFlightBean(IFlightDO flightDO, 
                                                IAirlineDO airlineDO, 
                                                IRouteDO route, 
                                                IAirportDO departure, 
                                                IAirportDO destination,
                                                IAircraftDO aircraftDO);
}
