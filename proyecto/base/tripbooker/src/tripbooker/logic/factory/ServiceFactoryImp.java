package tripbooker.logic.factory;

import tripbooker.logic.facade.BusinessFacade;
import tripbooker.logic.facade.IBusinessFacade;
import tripbooker.logic.flight.FlightServiceImp;
import tripbooker.logic.flight.IFlightService;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ServiceFactoryImp extends ServiceFactory{

    @Override
    public IFlightService getFlightService() {
        return new FlightServiceImp();
    }

    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }

}
