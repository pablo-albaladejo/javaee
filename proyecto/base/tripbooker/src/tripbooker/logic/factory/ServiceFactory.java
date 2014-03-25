package tripbooker.logic.factory;

import tripbooker.logic.facade.IBusinessFacade;
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
    
    public abstract IBusinessFacade getBusinessFacade();
    
    public abstract IFlightService getFlightService();
}
