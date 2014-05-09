package tripbooker.logic.facade.user;

import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.bean.flight.IFlightBean;
import tripbooker.dto.bean.route.IRouteBean;

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
    
    //Flight
    List<IFlightBean> getAllFlightsByAirports(String depatureAirpotCode, String destinationAirpotCode);
}
