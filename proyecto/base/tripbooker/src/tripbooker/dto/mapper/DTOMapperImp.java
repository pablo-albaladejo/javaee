package tripbooker.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.airport.IAirportDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.factory.DTOFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DTOMapperImp extends DTOMapper{
    
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
}
