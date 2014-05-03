package tripbooker.logic.city;

import java.util.List;
import tripbooker.dto.bean.city.ICityBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICityService {
    List<ICityBean> getAllCities();
    List<ICityBean> getAllCitiesByCountry(String code);
    ICityBean getCityByName(String name);
    boolean persistCity(ICityBean cityBean);
    boolean removeCity(ICityBean cityBean);
}

