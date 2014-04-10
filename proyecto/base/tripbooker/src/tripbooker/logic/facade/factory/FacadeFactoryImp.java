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
    public ISystemFacade getSystemFacade() {
        return new SystemFacade();
    }

    @Override
    public IAirlineFacade getAirlineFacade() {
        return new AirlineFacade();
    }

    @Override
    public IUserFacade getUserFacade() {
        return new UserFacade();
    }
    
    @Override
    public IBusinessFacade getBusinessFacade() {
        return new BusinessFacade();
    }
}
