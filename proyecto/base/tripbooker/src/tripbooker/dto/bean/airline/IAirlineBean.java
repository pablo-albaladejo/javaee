package tripbooker.dto.bean.airline;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirlineBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);

    String getCountryCode();
    void setCountryCode(String countryCode);
}
