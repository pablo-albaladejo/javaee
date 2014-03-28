package tripbooker.logic.country;

import java.util.List;
import tripbooker.dto.bean.country.ICountryBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICountryService {
    List<ICountryBean> getAllCountries();
    boolean persistCountry(ICountryBean countryBean);
    boolean removeCountry(ICountryBean countryBean);
}
