package tripbooker.logic.factory;

import tripbooker.logic.facade.airline.IAirlineBusinessFacade;
import tripbooker.logic.facade.business.IBusinessFacade;
import tripbooker.logic.facade.system.ISystemBusinessFacade;
import tripbooker.logic.facade.user.IUserBusinessFacade;
import tripbooker.logic.flight.IFlightService;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class ServiceFactory {
    private static ServiceFactory instance;
    
    public static synchronized ServiceFactory getInstance(){
        if(instance == null) instance = new ServiceFactoryImp();
        return instance;
    }
    
    //Profile Facades
    public abstract IBusinessFacade getBusinessFacade();
    public abstract ISystemBusinessFacade getSystemBusinessFacade();
    public abstract IAirlineBusinessFacade getAirlineBusinessFacade();
    public abstract IUserBusinessFacade getUserBusinessFacade();
    
    
    //Application Services
    public abstract IFlightService getFlightService();
}
