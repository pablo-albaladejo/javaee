package tripbooker.logic.facade.user;

import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class UserFacade implements IUserFacade{
    @Override
    public List<ICountryBean> getAllCountries() {
        return ServiceFactory.getInstance().getCountryService().getAllCountries();
    }
    
    @Override
    public ICountryBean getCountryByName(String name) {
        return ServiceFactory.getInstance().getCountryService().getCountryByName(name);
    }
    
    @Override
    public List<ICityBean> getAllCitiesByCountry(String code) {
        return ServiceFactory.getInstance().getCityService().getAllCitiesByCountry(code);
    }
    @Override
    public ICityBean getCityByName(String name) {
        return ServiceFactory.getInstance().getCityService().getCityByName(name);
    }
    
    @Override
    public List<IAirportBean> getAllAirportsByCity(String code) {
        return ServiceFactory.getInstance().getAirportService().getAllAirportsByCity(code);
    }
}
