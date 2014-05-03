package tripbooker.logic.facade.user;

import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IUserFacade {

    //Country
    List<ICountryBean> getAllCountries();
    ICountryBean getCountryByName(String name);
    
    //City
    List<ICityBean> getAllCitiesByCountry(String code);
    ICityBean getCityByName(String name);
    
    //Airport
    List<IAirportBean> getAllAirportsByCity(String code);
}
