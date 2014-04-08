package tripbooker.logic.facade.factory;

import tripbooker.logic.facade.airline.IAirlineFacade;
import tripbooker.logic.facade.business.IBusinessFacade;
import tripbooker.logic.facade.system.ISystemFacade;
import tripbooker.logic.facade.user.IUserFacade;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class FacadeFactory {
    private static FacadeFactory instance;
    
    public static synchronized FacadeFactory getInstance(){
        if(instance == null) instance = new FacadeFactoryImp();
        return instance;
    }
    
    public abstract IBusinessFacade getBusinessFacade();
    public abstract ISystemFacade getSystemBusinessFacade();
    public abstract IAirlineFacade getAirlineBusinessFacade();
    public abstract IUserFacade getUserBusinessFacade();

}
