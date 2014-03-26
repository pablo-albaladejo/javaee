package tripbooker.logic.facade.business;

import java.util.List;
import tripbooker.dto.bean.IFlightBean;
import tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BusinessFacade implements IBusinessFacade{

    @Override
    public List<IFlightBean> getAllFlights() {
         return ServiceFactory.getInstance().getFlightService().getAllFlights();
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByAirline(String airlineCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByAirline(airlineCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDeparture(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDeparture(airportCode);
    }
    
    @Override
    public List<IFlightBean> getAllFlightsByDestination(String airportCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByDestination(airportCode);
    }

    @Override
    public List<IFlightBean> getAllFlightsByRoute(String depatureCode, String destinationCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByRoute(depatureCode,destinationCode);
    }
}
