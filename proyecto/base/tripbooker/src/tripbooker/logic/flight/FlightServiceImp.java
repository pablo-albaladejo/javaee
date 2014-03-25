package tripbooker.logic.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tripbooker.dto.bean.IFlightBean;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.dto.domain.flight.IFlightDO;
import tripbooker.dto.domain.route.IRouteDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FlightServiceImp implements IFlightService{

    @Override
    public List<IFlightBean> getAllFlights(String airlineCode) {
        List<IFlightDO> flightDOlist = null;
        List<IFlightBean> result = new ArrayList<IFlightBean>();
        try {
            //Get Airline
            IAirlineDO airlineDO = DAOFactory.getInstance().getAirlineDAO().getAirlineByCode(airlineCode);
            
            //Get all the flights by Airline
            flightDOlist = DAOFactory.getInstance().getFlightDAO().getFlightsByAirline(airlineDO.getAirlineID());
            
            //Get Route
            IRouteDO routeDO = null;
            
            //Convert the data
            for(IFlightDO flightDO : flightDOlist){
                IFlightBean flightBean = DTOMapper.getInstance().getFlightBean(flightDO,airlineDO,routeDO);
            }
            
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

}
