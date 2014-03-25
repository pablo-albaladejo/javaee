package tripbooker.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.IFlightBean;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.factory.DTOFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DTOMapperImp extends DTOMapper{
    
    @Override
    public IFlightBean getFlightBean(IFlightDO flightDO, IAirlineDO airlineDO, IRouteDO routeDO){
        IFlightBean flightBean = DTOFactory.getInstance().getFlightBean();
        
        flightBean.setCode(flightDO.getCode());
        flightBean.setAirline(airlineDO.getName());
        flightBean.setDeparture(airlineDO.getName());
        flightBean.setDestination(airlineDO.getName());
        
        return flightBean;
    }
}
