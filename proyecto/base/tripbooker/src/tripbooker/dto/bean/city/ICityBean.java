package tripbooker.dto.bean.city;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICityBean extends Serializable{
    String getName();
    void setName(String name);

    String getCode();
    void setCode(String code);
    
    String getCountryCode();
    void setCountryCode(String countryCode);

    String getCountryName();
    void setCountryName(String countryName);
}
