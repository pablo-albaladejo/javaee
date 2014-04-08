package tripbooker.logic.facade.factory;

import tripbooker.logic.facade.airline.AirlineFacade;
import tripbooker.logic.facade.airline.IAirlineFacade;
import tripbooker.logic.facade.business.BusinessFacade;
import tripbooker.logic.facade.business.IBusinessFacade;
import tripbooker.logic.facade.system.ISystemFacade;
import tripbooker.logic.facade.system.SystemFacade;
import tripbooker.logic.facade.user.IUserFacade;
import tripbooker.logic.facade.user.UserFacade;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class FacadeFactoryImp extends FacadeFactory{
    @Override
    public ISystemFacade getSystemBusinessFacade() {
        return new SystemFacade();
    }

    @Override
    public IAirlineFacade getAirlineBusinessFacade() {
        return new AirlineFacade();
    }

    @Override
    public IUserFacade getUserBusinessFacade() {
        return new UserFacade();
    }
    
    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }
}
